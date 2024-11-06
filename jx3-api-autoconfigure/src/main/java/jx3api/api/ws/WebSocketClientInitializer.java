package jx3api.api.ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import jx3api.api.config.WebSocketProperties;
import jx3api.api.ws.action.WsActionDataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * webSocket服务类
 *
 * @author Grafie
 * @since 1.0.0
 */

public class WebSocketClientInitializer {
    private final Logger logger = LoggerFactory.getLogger(WebSocketClientInitializer.class);
    private WebSocketProperties webSocketProperties;
    private CustomWebSocketHandler webSocketHandler;
    private WebSocketConnectionManager webSocketConnectionManager;
    private IWsDataPushService iWsDataPushService;
    private ObjectMapper objectMapper;

    public WebSocketClientInitializer(WebSocketProperties webSocketProperties,
                                      IWsDataPushService iWsDataPushService,
                                      ObjectMapper objectMapper) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.webSocketProperties = webSocketProperties;
        this.iWsDataPushService = iWsDataPushService;
        this.objectMapper = objectMapper;
        connect();
        // 初始化ws推送事件中，序列化相关信息
        initWsActionData(webSocketProperties);
    }

    private void initWsActionData(WebSocketProperties webSocketProperties) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        WsActionDataManager wsActionDataManager = new WsActionDataManager();
        wsActionDataManager.init(webSocketProperties.getWsDataBeanBasePackage());
    }

    private void connect() {
        beforeStartCheck();
        checkOnConnect();
    }

    private void beforeStartCheck() {
        checkProperties();
        checkWsHandler();
        checkConnectionManager();
    }

    private void checkConnectionManager() {
        if (this.webSocketConnectionManager != null) {
            return;
        }
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketConnectionManager connectionManager = new WebSocketConnectionManager(webSocketClient,
                this.webSocketHandler, webSocketProperties.getWsUrl());
        connectionManager.setAutoStartup(true);
        List<String> token = new ArrayList<>();
        token.add(webSocketProperties.getWsToken());
        connectionManager.getHeaders().put("token", token);
        this.webSocketConnectionManager = connectionManager;
    }

    private void checkWsHandler() {
        if (this.webSocketHandler == null) {
            this.webSocketHandler = new CustomWebSocketHandler(this, iWsDataPushService,objectMapper);
        }
    }

    private void checkProperties() {
        if (webSocketProperties == null || webSocketProperties.getWsUrl() == null
                || webSocketProperties.getWsUrl().trim().length() <= 0) {
            throw new NullPointerException("webSocketProperties or wsUrl can not be null");
        }
    }

    /**
     * 异步校验连接状态，如果当前连接关闭，则尝试重连
     */
    @Async
    public void checkOnConnect() {
        synchronized (WebSocketClientInitializer.class) {
            int reConnectTime = 0;
            while (reConnectTime < webSocketProperties.getReConnectMaxTimes()) {
                if (getConnectStatus()) {
                    return;
                }
                try {
                    beforeStartCheck();
                    webSocketConnectionManager.start();
                    if (getConnectStatus()) {
                        logger.info("webSocket reConnect success");
                        return;
                    }
                } catch (Exception e) {
                    logger.error("webSocket reConnect error，remote server url=>{}", webSocketProperties.getWsUrl(), e);
                }
                reConnectTime++;

            }
        }
    }

    /**
     * 获取连接状态
     *
     * @return true:connected
     */
    public boolean getConnectStatus() {
        synchronized (WebSocketClientInitializer.class) {
            return webSocketConnectionManager.isConnected();
        }
    }
}

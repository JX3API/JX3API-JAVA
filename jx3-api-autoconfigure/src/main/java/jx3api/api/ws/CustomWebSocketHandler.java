package jx3api.api.ws;

import jx3api.api.util.TimeUtils;
import jx3api.api.ws.action.WsActionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PingMessage;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ws 处理器
 *
 * @author Grafie
 * @since 1.0.0
 */

public class CustomWebSocketHandler extends TextWebSocketHandler {
    private final Logger logger = LoggerFactory.getLogger(CustomWebSocketHandler.class);
    private WebSocketClientInitializer webSocketClientInitializer;
    private WsActionHandler wsActionHandler;
    private WebSocketSession webSocketSession;
    private ScheduledExecutorService executorService;

    public CustomWebSocketHandler(WebSocketClientInitializer webSocketClientInitializer, IWsDataPushService iWsDataPushService) {
        this.webSocketClientInitializer = webSocketClientInitializer;
        wsActionHandler = new WsActionHandler(iWsDataPushService);
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        logger.info("WebSocket connect remote server success");
        this.webSocketSession = session;
        startPingTask();
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        wsActionHandler.pushMessage(message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        logger.error("WebSocket connection closed, try reConnect");
        webSocketClientInitializer.checkOnConnect();
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
        logger.info("Received Pong message.");
    }

    /**
     * 发送ping消息
     *
     * @throws IOException exception
     */
    private void startPingTask() {
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::sendPingMessage, 0, 5, TimeUnit.SECONDS);
    }

    private void sendPingMessage() {
        if (webSocketClientInitializer.getConnectStatus()) {
            try {
                this.webSocketSession.sendMessage(new PingMessage());
                logger.info("Sent Ping message, now time=>{}", TimeUtils.getNowString());
            } catch (Exception e) {
                logger.error("sent ping message error", e);
            }

        }
    }
}

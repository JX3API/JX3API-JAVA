package jx3api.api.ws.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import jx3api.api.ws.IWsDataPushService;
import jx3api.api.ws.data.BaseWsData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;

import java.util.Map;

/**
 * 基础ws实践配置
 *
 * @author Grafie
 * @since 1.0.0
 */
public class WsActionHandler {
    private static final Logger logger = LoggerFactory.getLogger(WsActionHandler.class);
    /**
     * 需要接入方实现的数据推送接口
     */
    private IWsDataPushService wsDataPushService;
    private final ObjectMapper objectMapper;

    public WsActionHandler(IWsDataPushService wsDataPushService, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.wsDataPushService = wsDataPushService;
    }

    /**
     * 推送数据
     *
     * @param textMessage 来自ws的数据
     */
    public void pushMessage(TextMessage textMessage) {
        BaseWsData baseWsData = transferDataFromBase(textMessage);
        wsDataPushService.pushDataByWs(baseWsData);
    }

    /**
     * 转换数据。将ws数据转换为BaseWsData
     *
     * @param textMessage ws数据
     * @return 转换后的数据
     */
    private BaseWsData transferDataFromBase(TextMessage textMessage) {
        Map<String, Object> wsOriginalData = null;
        try {
            wsOriginalData = objectMapper.readValue(textMessage.getPayload(), Map.class);
        } catch (Exception e) {
            logger.error("序列化ws原始数据失败，原始数据=>[{}]", textMessage.getPayload(), e);
        }
        BaseWsData baseWsData = null;
        if (wsOriginalData != null) {
            try {
                logger.info("接收到ws消息，消息内容=>[{}]", wsOriginalData);
                int action = (int) wsOriginalData.get("action");
                Class<BaseWsData> baseWsDataClass = WsActionDataManager.getWsDataByAction(action);
                if (baseWsDataClass != null) {
                    baseWsData = objectMapper.convertValue(wsOriginalData.get("data"), baseWsDataClass);
                    baseWsData.setAction(action);
                }
            } catch (Exception e) {
                logger.error("序列化wsData数据失败，原始数据=>[{}]", textMessage.getPayload(), e);
            }
        }
        if (baseWsData == null) {
            logger.error("未知ws事件消息，消息内容=>[{}]", textMessage.getPayload());
        }
        return baseWsData;
    }
}

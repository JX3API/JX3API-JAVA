package jx3api.api.ws;

import jx3api.api.ws.data.BaseWsData;

/**
 * 接入方需要实现该类
 *
 * @author Grafie
 * @since 1.0.0
 */
public interface IWsDataPushService {
    /**
     * 推送来自ws的数据信息。具体实现类需要又接入方实现
     *
     * @param baseWsData ws数据
     */
    void pushDataByWs(BaseWsData baseWsData);
}

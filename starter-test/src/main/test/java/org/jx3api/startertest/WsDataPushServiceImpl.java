package org.jx3api.startertest;

import jx3api.api.ws.IWsDataPushService;
import jx3api.api.ws.data.BaseWsData;
import org.springframework.stereotype.Service;

/**
 * @author Grafie
 * @since 1.0.0
 */
@Service
public class WsDataPushServiceImpl implements IWsDataPushService {
    @Override
    public void pushDataByWs(BaseWsData baseWsData) {
        System.out.println(baseWsData);
    }
}

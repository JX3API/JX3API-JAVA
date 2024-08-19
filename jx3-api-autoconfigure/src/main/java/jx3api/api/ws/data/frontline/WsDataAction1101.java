package jx3api.api.ws.data.frontline;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.ws.data.BaseWsData;
import jx3api.api.ws.data.WsActionData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 前线战况-粮仓被劫
 * @author Grafie
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@WsActionData(actionCode = 1101)
public class WsDataAction1101 extends BaseWsData {
    @JsonProperty("castle")
    private String castle;

    @JsonProperty("camp_name")
    private String campName;
}

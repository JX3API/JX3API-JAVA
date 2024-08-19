package jx3api.api.ws.data.frontline;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.ws.data.BaseWsData;
import jx3api.api.ws.data.WsActionData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 前线战况-据点占领（有帮会）
 * @author Grafie
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@WsActionData(actionCode = 1104)
public class WsDataAction1104 extends BaseWsData {
    @JsonProperty("camp_name")
    private String campName;

    @JsonProperty("castle")
    private String castle;

    @JsonProperty("tong_name")
    private String tongName;

}

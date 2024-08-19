package jx3api.api.ws.data.dilu;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.ws.data.BaseWsData;
import jx3api.api.ws.data.WsActionData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 的卢 竞拍
 *
 * @author Grafie
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@WsActionData(actionCode = 1013)
public class WsDataAction1013 extends BaseWsData {

    @JsonProperty("role_name")
    private String roleName;

    @JsonProperty("camp_name")
    private String campName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("amount")
    private String amount;

}

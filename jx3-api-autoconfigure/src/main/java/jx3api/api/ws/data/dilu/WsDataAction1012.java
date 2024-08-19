package jx3api.api.ws.data.dilu;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.ws.data.BaseWsData;
import jx3api.api.ws.data.WsActionData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 的卢 抓获
 *
 * @author Grafie
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@WsActionData(actionCode = 1012)
public class WsDataAction1012 extends BaseWsData {

    @JsonProperty("role_name")
    private String roleName;

    @JsonProperty("camp_name")
    private String campName;

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("level")
    private String level;

    @JsonProperty("name")
    private String name;

}

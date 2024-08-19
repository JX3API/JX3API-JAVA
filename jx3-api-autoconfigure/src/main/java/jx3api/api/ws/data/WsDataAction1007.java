package jx3api.api.ws.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 玄晶提醒
 * @author Grafie
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@WsActionData(actionCode = 1007)
public class WsDataAction1007 extends BaseWsData{
    @JsonProperty("role_name")
    private String roleName;

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("name")
    private String name;
}

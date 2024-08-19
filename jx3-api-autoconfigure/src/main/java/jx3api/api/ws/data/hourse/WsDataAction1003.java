package jx3api.api.ws.data.hourse;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.ws.data.BaseWsData;
import jx3api.api.ws.data.WsActionData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 抓马报时 捕获
 * @author Grafie
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@WsActionData(actionCode = 1003)
public class WsDataAction1003 extends BaseWsData {
    @JsonProperty("name")
    private String name;

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("horse")
    private String horse;
}

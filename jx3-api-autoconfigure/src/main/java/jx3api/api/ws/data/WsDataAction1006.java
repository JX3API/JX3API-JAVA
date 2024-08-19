package jx3api.api.ws.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 烟花报时
 *
 * @author Grafie
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@WsActionData(actionCode = 1006)
public class WsDataAction1006 extends BaseWsData {
    @JsonProperty("name")
    private String name;

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("sender")
    private String sender;

    @JsonProperty("recipient")
    private String recipient;

}

package jx3api.api.ws.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 奇遇报时
 *
 * @author Grafie
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@WsActionData(actionCode = 1001)
public class WsDataAction1001 extends BaseWsData {

    @JsonProperty("name")
    private String name;

    @JsonProperty("event")
    private String event;

    @JsonProperty("level")
    private int level;

}

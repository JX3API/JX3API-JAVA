package jx3api.api.ws.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 追魂点名
 *  @author Grafie
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@WsActionData(actionCode = 1008)
public class WsDataAction1008 extends BaseWsData{
    @JsonProperty("subserver")
    private String subserver;

    @JsonProperty("name")
    private String name;

    @JsonProperty("realm")
    private String realm;
}

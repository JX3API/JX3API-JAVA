package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FiveStone {
    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private String level;
    @JsonProperty("max")
    private String max;
    @JsonProperty("min")
    private String min;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("subKind")
    private String subKind;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("percent")
    private String percent;
}

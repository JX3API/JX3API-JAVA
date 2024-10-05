package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ColorStoneAttribute {
    @JsonProperty("max")
    private Integer max;
    @JsonProperty("min")
    private Integer min;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("percent")
    private Boolean percent;
}

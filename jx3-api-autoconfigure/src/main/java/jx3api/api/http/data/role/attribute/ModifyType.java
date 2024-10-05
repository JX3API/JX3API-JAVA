package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModifyType {
    @JsonProperty("name")
    private String name;

    @JsonProperty("max")
    private String max;

    @JsonProperty("min")
    private String min;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("percent")
    private Boolean percent;
}

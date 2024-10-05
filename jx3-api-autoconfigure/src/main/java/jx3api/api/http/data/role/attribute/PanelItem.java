package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PanelItem {
    @JsonProperty("name")
    private String name;

    @JsonProperty("percent")
    private boolean percent;

    @JsonProperty("value")
    private Integer value;
}

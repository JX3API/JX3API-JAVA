package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QixueItem {
    @JsonProperty("name")
    private String name;

    @JsonProperty("level")
    private int level;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("subKind")
    private String subKind;

    @JsonProperty("desc")
    private String desc;
}

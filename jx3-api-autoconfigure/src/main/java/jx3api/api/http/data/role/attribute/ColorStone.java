package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ColorStone {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("class")
    private String classType;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("subKind")
    private String subKind;
    @JsonProperty("attribute")
    private List<ColorStoneAttribute> attribute;
}

package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EnchantItem {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("level")
    private String level;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("attributes")
    private List<Attribute> attributes;
}

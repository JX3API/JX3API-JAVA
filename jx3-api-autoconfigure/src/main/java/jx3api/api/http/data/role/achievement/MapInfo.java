package jx3api.api.http.data.role.achievement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MapInfo {
    @JsonProperty("icon")
    private String icon;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;
}

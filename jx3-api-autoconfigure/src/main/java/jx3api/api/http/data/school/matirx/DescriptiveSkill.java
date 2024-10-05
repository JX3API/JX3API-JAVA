package jx3api.api.http.data.school.matirx;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DescriptiveSkill {
    @JsonProperty("desc")
    private String description;

    @JsonProperty("level")
    private int level;

    @JsonProperty("name")
    private String name;
}

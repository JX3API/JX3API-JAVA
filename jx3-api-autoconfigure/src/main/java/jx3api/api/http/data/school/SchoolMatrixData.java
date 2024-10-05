package jx3api.api.http.data.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 阵法效果
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class SchoolMatrixData {
    @JsonProperty("name")
    private String name;

    @JsonProperty("skillName")
    private String skillName;

    @JsonProperty("descs")
    private List<DescriptiveSkill> descs;
}

@Data
class DescriptiveSkill {
    @JsonProperty("desc")
    private String description;

    @JsonProperty("level")
    private int level;

    @JsonProperty("name")
    private String name;
}

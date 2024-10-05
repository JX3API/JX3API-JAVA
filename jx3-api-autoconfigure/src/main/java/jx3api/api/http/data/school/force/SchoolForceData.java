package jx3api.api.http.data.school.force;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 奇穴效果
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class SchoolForceData {
    @JsonProperty("level")
    private int level;

    @JsonProperty("data")
    private List<SkillInfo> data;

}


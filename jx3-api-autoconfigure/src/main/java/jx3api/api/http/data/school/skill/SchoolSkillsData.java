package jx3api.api.http.data.school.skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 技能效果
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class SchoolSkillsData {
    @JsonProperty("class")
    private String className;

    @JsonProperty("data")
    private List<Skill> skills;
}


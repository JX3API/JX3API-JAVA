package jx3api.api.http.data;

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

@Data
class SkillInfo {
    @JsonProperty("name")
    private String name;

    @JsonProperty("class")
    private Integer skillClass;

    @JsonProperty("specialDesc")
    private String specialDesc;

    @JsonProperty("simpleDesc")
    private String simpleDesc;

    @JsonProperty("desc")
    private String description;

    @JsonProperty("interval")
    private String interval;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("subKind")
    private String subKind;

    @JsonProperty("consumption")
    private String consumption;

    @JsonProperty("releaseType")
    private String releaseType;

    @JsonProperty("weapon")
    private String weapon;

    @JsonProperty("distance")
    private String distance;


}

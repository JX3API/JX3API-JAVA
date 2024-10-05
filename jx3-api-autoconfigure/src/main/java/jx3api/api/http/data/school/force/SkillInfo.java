package jx3api.api.http.data.school.force;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SkillInfo {
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

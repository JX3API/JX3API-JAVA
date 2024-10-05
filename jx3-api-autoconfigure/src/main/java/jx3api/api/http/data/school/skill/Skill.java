package jx3api.api.http.data.school.skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Skill {
    @JsonProperty("name")
    private String name;

    @JsonProperty("simpleDesc")
    private String simpleDescription;

    @JsonProperty("desc")
    private String description;

    @JsonProperty("specialDesc")
    private String specialDescription;

    @JsonProperty("interval")
    private String interval;

    @JsonProperty("consumption")
    private String consumption;

    @JsonProperty("distance")
    private String distance;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("subKind")
    private String subKind;

    @JsonProperty("releaseType")
    private String releaseType;

    @JsonProperty("weapon")
    private String weapon;
}

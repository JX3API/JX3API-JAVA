package jx3api.api.http.data.role.achievement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AchievementData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("likes")
    private Integer likes;

    @JsonProperty("name")
    private String name;

    @JsonProperty("class")
    private String achievementClass;

    @JsonProperty("subClass")
    private String subClass;

    @JsonProperty("desc")
    private String description;

    @JsonProperty("detail")
    private String detail;

    @JsonProperty("maps")
    private List<MapInfo> maps;

    @JsonProperty("isFinished")
    private Boolean isFinished;

    @JsonProperty("isFav")
    private Boolean isFav;

    @JsonProperty("type")
    private String type;

    @JsonProperty("currentValue")
    private Integer currentValue;

    @JsonProperty("triggerValue")
    private Integer triggerValue;

    @JsonProperty("subset")
    private List<Object> subset;

    @JsonProperty("rewardItem")
    private Object rewardItem;

    @JsonProperty("rewardPoint")
    private Integer rewardPoint;

    @JsonProperty("rewardPrefix")
    private String rewardPrefix;

    @JsonProperty("rewardSuffix")
    private String rewardSuffix;
}

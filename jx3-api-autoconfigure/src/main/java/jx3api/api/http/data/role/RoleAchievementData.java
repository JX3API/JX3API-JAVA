package jx3api.api.http.data.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 成就百科
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class RoleAchievementData {
    @JsonProperty("zoneName")
    private String zoneName;

    @JsonProperty("serverName")
    private String serverName;

    @JsonProperty("roleName")
    private String roleName;

    @JsonProperty("roleId")
    private String roleId;

    @JsonProperty("globalRoleId")
    private String globalRoleId;

    @JsonProperty("forceName")
    private String forceName;

    @JsonProperty("forceId")
    private String forceId;

    @JsonProperty("bodyName")
    private String bodyName;

    @JsonProperty("bodyId")
    private String bodyId;

    @JsonProperty("tongName")
    private String tongName;

    @JsonProperty("tongId")
    private String tongId;

    @JsonProperty("campName")
    private String campName;

    @JsonProperty("campId")
    private String campId;

    @JsonProperty("personName")
    private String personName;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("personAvatar")
    private String personAvatar;

    @JsonProperty("data")
    private List<AchievementData> data;
}

@Data
class AchievementData {
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

@Data
class MapInfo {
    @JsonProperty("icon")
    private String icon;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;
}

package jx3api.api.http.data.role.achievement;

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


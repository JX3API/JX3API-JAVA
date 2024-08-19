package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 副本记录
 *
 * @author grafie
 * @since 2024/6/23  16:19
 */
@Data
public class RoleTeamCdListData {
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
    private List<CdInfo> data;
}

@Data
class CdInfo {
    @JsonProperty("mapIcon")
    private String mapIcon;
    @JsonProperty("mapId")
    private String mapId;
    @JsonProperty("mapName")
    private String mapName;
    @JsonProperty("mapType")
    private String mapType;
    @JsonProperty("bossCount")
    private Integer bossCount;
    @JsonProperty("bossFinished")
    private Integer bossFinished;
    @JsonProperty("bossProgress")
    private List<BossProgressInfo> bossProgress;
}

@Data
class BossProgressInfo {
    @JsonProperty("finished")
    private Boolean finished;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("progressId")
    private String progressId;

}

package jx3api.api.http.data.role.monster;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

import java.util.List;

/**
 * 百战精耐
 *
 * @author Grafie
 * @since 2024/9/25  11:12
 */
@Data
public class RoleMonsterData {
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
    @JsonProperty("gameEnergy")
    private String gameEnergy;
    @JsonProperty("gameStamina")
    private String gameStamina;
    @JsonProperty("skillCount")
    private String skillCount;
    @JsonProperty("updateTime")
    private String updateTime;
    @JsonProperty("skillList")
    private List<MonsterSkill> skillList;

    public void setTime(Long updateTime) {
        this.updateTime = TimeUtils.timeFormatting(updateTime);
    }
}


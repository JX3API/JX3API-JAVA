package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 装备属性
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class RoleAttributeData {
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

    @JsonProperty("kungfuName")
    private String kungfuName;

    @JsonProperty("kungfuId")
    private String kungfuId;

    @JsonProperty("equipList")
    private List<EquipItem> equipList;

    @JsonProperty("qixueList")
    private List<QixueItem> qixueList;

    @JsonProperty("panelList")
    private PanelList panelList;
}


package jx3api.api.http.data.role.monster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MonsterSkill {
    @JsonProperty("bDeprecatedl")
    private Boolean bDeprecatedl;
    @JsonProperty("bDeprecated")
    private Boolean bDeprecated;
    @JsonProperty("dwInSkillID")
    private Long dwInSkillID;
    @JsonProperty("dwOutSkillID")
    private Long dwOutSkillID;
    @JsonProperty("nColor")
    private Integer nColor;
    @JsonProperty("nCost")
    private Integer nCost;
    @JsonProperty("nLevel")
    private Integer nLevel;
    @JsonProperty("szBossName")
    private String szBossName;
    @JsonProperty("szSkillName")
    private String szSkillName;
    @JsonProperty("szType")
    private String szType;
}

package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EquipItem {
    @JsonProperty("name")
    private String name;

    @JsonProperty("class")
    private String equipClass;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("subKind")
    private String subKind;

    @JsonProperty("quality")
    private String quality;

    @JsonProperty("strengthLevel")
    private String strengthLevel;

    @JsonProperty("maxStrengthLevel")
    private String maxStrengthLevel;

    @JsonProperty("color")
    private String color;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("source")
    private String source;

    @JsonProperty("modifyType")
    private List<ModifyType> modifyType;

    @JsonProperty("permanentEnchant")
    private List<EnchantItem> permanentEnchant;

    @JsonProperty("fiveStone")
    private List<FiveStone> fiveStone;

    @JsonProperty("Base1Type")
    private Base1Type base1Type;
    @JsonProperty("Base2Type")
    private Base2Type base2Type;
    @JsonProperty("EquipType")
    private EquipType equipType;
    @JsonProperty("ID")
    private Long id;
    @JsonProperty("UID")
    private Long uid;
    @JsonProperty("colorStone")
    private ColorStone colorStone;
    @JsonProperty("commonEnchant")
    private EquipCommonEnchant commonEnchant;
}

package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EquipType {
    @JsonProperty("Desc")
    private String desc;
    @JsonProperty("EquipUsage")
    private Integer equipUsage;
    @JsonProperty("Icon")
    private String icon;
}

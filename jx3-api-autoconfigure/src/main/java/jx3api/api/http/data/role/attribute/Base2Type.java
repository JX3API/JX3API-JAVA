package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Base2Type {
    @JsonProperty("Attrib")
    private Attrib attrib;
    @JsonProperty("Desc")
    private String desc;
    @JsonProperty("Base2Max")
    private String base2Max;
    @JsonProperty("Base2Min")
    private String base2Min;
}

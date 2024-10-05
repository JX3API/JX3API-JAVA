package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Base1Type {
    @JsonProperty("Attrib")
    private Attrib attrib;
    @JsonProperty("Desc")
    private String desc;
    @JsonProperty("Base1Max")
    private String base1Max;
    @JsonProperty("Base1Min")
    private String base1Min;

}

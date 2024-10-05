package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Attribute {
    @JsonProperty("max")
    private String max;

    @JsonProperty("min")
    private String min;

    @JsonProperty("attrib")
    private List<AttribDesc> attrib;
}

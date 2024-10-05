package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AttribDesc {
    @JsonProperty("desc")
    private String desc;
}

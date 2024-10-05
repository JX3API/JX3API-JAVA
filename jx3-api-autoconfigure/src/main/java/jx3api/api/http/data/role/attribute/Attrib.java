package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Attrib {
    @JsonProperty("GeneratedBase")
    private String generatedBase;
    @JsonProperty("GeneratedMagic")
    private String generatedMagic;
    @JsonProperty("HorseBase")
    private String horseBase;
    @JsonProperty("HorseMagic")
    private String horseMagic;
    @JsonProperty("percent")
    private Boolean percent;
    @JsonProperty("Type")
    private String type;
}

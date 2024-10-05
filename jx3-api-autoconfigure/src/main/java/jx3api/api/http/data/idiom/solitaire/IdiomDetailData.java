package jx3api.api.http.data.idiom.solitaire;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IdiomDetailData {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tone")
    private String tone;

    @JsonProperty("pinyin")
    private String pinyin;

    @JsonProperty("abbreviation")
    private String abbreviation;

    @JsonProperty("first")
    private String first;

    @JsonProperty("last")
    private String last;

    @JsonProperty("derivation")
    private String derivation;

    @JsonProperty("example")
    private String example;

    @JsonProperty("explanation")
    private String explanation;
}

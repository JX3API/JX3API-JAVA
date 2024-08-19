package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 成语接龙
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class IdiomSolitaireData {
    @JsonProperty("question")
    private IdiomDetailData question;
    @JsonProperty("answer")
    private IdiomDetailData answer;
}

@Data
class IdiomDetailData {
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
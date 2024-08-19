package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 科举试题
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ExamAnswerData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("question")
    private String question;

    @JsonProperty("answer")
    private String answer;

    @JsonProperty("correctness")
    private Integer correctness;

    @JsonProperty("index")
    private Integer index;

    @JsonProperty("pinyin")
    private String pinyin;
}

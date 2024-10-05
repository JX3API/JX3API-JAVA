package jx3api.api.http.data.other;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 挂件详情
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class OtherPendantData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("class")
    private String itemClass;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ui")
    private String ui;

    @JsonProperty("source")
    private String source;

    @JsonProperty("desc")
    private String description;
}

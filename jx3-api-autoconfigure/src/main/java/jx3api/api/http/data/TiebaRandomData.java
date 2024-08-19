package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 八卦帖子
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class TiebaRandomData {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("class")
    private String classType;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("name")
    private String name;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private Long url;

    @JsonProperty("date")
    private String date;
}

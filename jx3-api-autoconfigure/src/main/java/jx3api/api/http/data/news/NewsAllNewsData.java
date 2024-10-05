package jx3api.api.http.data.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 新闻资讯
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class NewsAllNewsData {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("token")
    private Long token;

    @JsonProperty("class")
    private String classType;

    @JsonProperty("title")
    private String title;

    @JsonProperty("date")
    private String date;

    @JsonProperty("url")
    private String url;

}

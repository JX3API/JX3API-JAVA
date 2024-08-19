package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 全服榜单
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class RankServerStatisticalData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("class")
    private String prestigeClass;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("name")
    private String name;

    @JsonProperty("school")
    private String school;

    @JsonProperty("index")
    private Integer index;

    @JsonProperty("level")
    private Integer level;

    @JsonProperty("camp_name")
    private String campName;

    @JsonProperty("tong_name")
    private String tongName;

    @JsonProperty("score")
    private Long score;

    @JsonProperty("datetime")
    private String datetime;
}

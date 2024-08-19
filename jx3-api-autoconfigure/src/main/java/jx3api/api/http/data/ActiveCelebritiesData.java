package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 行侠事件
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ActiveCelebritiesData {

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("event")
    private String event;

    @JsonProperty("site")
    private String site;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("time")
    private String time;
}

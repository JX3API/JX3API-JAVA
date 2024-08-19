package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 掉落汇总
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ValuablesCollectData {
    @JsonProperty("name")
    private String name;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("data")
    private DropData data;
}

@Data
class DropData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("name")
    private String name;

    @JsonProperty("role_name")
    private String roleName;

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("time")
    private String time;

    public void setTime(long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}
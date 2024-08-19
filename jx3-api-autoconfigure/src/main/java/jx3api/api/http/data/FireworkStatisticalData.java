package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 烟花统计
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class FireworkStatisticalData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("name")
    private String name;

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("sender")
    private String sender;

    @JsonProperty("receive")
    private String recipient;

    @JsonProperty("mode")
    private Integer mode;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("time")
    private String time;

    public void setTime(long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

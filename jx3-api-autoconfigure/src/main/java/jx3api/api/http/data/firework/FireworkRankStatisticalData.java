package jx3api.api.http.data.firework;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 烟花排行
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class FireworkRankStatisticalData {
    @JsonProperty("server")
    private String server;

    @JsonProperty("sender")
    private String sender;

    @JsonProperty("receive")
    private String receive;

    @JsonProperty("name")
    private String name;

    @JsonProperty("count")
    private int count;

    @JsonProperty("time")
    private String time;

    public void setTime(long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

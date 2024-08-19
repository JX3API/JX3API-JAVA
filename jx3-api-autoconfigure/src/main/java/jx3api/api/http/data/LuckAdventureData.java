package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 奇遇记录
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class LuckAdventureData {
    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("name")
    private String name;

    @JsonProperty("event")
    private String event;

    @JsonProperty("level")
    private Integer level;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("time")
    private String time;

    public void setTime(long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

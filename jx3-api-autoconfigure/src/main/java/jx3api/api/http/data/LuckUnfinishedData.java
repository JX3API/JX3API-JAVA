package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 未出奇遇
 * @author Grafie
 * @since 2024/9/25  10:20
 */
@Data
public class LuckUnfinishedData {
    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("last")
    private Last last;
}
@Data
class Last{
    @JsonProperty("id")
    private Long id;
    @JsonProperty("zone")
    private String zone;
    @JsonProperty("server")
    private String server;
    @JsonProperty("name")
    private String name;
    @JsonProperty("event")
    private String event;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("time")
    private String time;
    public void setTime(Long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

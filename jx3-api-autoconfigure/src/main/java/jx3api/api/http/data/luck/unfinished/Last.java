package jx3api.api.http.data.luck.unfinished;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

@Data
public class Last {
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

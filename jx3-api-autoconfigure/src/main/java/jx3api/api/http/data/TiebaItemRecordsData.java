package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 贴吧物价
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class TiebaItemRecordsData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private Long url;

    @JsonProperty("context")
    private String context;

    @JsonProperty("reply")
    private Long reply;

    @JsonProperty("token")
    private String token;

    @JsonProperty("floor")
    private Integer floor;

    @JsonProperty("time")
    private String time;

    public void setTime(long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

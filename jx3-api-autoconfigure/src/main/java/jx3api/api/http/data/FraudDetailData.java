package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

import java.util.List;

/**
 * @author grafie
 * @since 2024/6/23  16:56
 */
@Data
public class FraudDetailData {
    @JsonProperty("server")
    private String server;

    @JsonProperty("tieba")
    private String tieba;

    @JsonProperty("data")
    private List<DetailInfo> data;
}

@Data
class DetailInfo {
    @JsonProperty("title")
    private String title;
    @JsonProperty("tid")
    private Long tid;
    @JsonProperty("text")
    private String text;
    @JsonProperty("time")
    public String time;

    public void setTime(Long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

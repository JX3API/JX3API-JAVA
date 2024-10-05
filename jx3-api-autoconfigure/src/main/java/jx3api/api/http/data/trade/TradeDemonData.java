package jx3api.api.http.data.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 金币比例
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class TradeDemonData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("tieba")
    private String tieba;

    @JsonProperty("wanbaolou")
    private String wanbaolou;

    @JsonProperty("dd373")
    private String dd373;

    @JsonProperty("uu898")
    private String uu898;

    @JsonProperty("5173")
    private String five173;

    @JsonProperty("7881")
    private String seven881;

    @JsonProperty("time")
    private String time;

    @JsonProperty("date")
    private String date;

    public void setTime(long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 诛恶事件
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ServerAntiviceData {
    @JsonProperty("id")
    private int id;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("time")
    private String time;

    public void setTime(long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

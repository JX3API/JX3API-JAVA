package jx3api.api.http.data.server.sand;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

import java.util.List;

/**
 * 沙盘信息
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ServerSandData {
    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("reset")
    private Integer reset;

    @JsonProperty("update")
    private String update;

    @JsonProperty("data")
    private List<CastleInfo> data;

    public void setUpdate(Long update) {
        this.update =TimeUtils.timeFormatting(update);
    }

}


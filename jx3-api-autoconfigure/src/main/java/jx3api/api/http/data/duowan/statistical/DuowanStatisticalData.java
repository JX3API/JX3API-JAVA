package jx3api.api.http.data.duowan.statistical;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 歪歪频道
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class DuowanStatisticalData {
    @JsonProperty("server")
    private String server;
    @JsonProperty("data")
    private List<DuowanInfo> data;

}


package jx3api.api.http.data.fraud.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
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


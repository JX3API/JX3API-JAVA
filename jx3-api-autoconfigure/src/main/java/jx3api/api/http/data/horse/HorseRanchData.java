package jx3api.api.http.data.horse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author grafie
 * @since 2024/6/23  16:46
 */
@Data
public class HorseRanchData {

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("note")
    private String note;

    @JsonProperty("data")
    private Map<String, List<String>> data;
}

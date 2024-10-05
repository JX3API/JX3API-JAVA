package jx3api.api.http.data.server.leader;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 关隘首领
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ServerLeaderData {
    @JsonProperty("server")
    private String server;

    @JsonProperty("data")
    private List<CastleData> castleDataList;
}


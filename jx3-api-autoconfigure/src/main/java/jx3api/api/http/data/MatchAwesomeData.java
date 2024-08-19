package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 名剑排行
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MatchAwesomeData {
    @JsonProperty("zoneName")
    private String zoneName;

    @JsonProperty("serverName")
    private String serverName;

    @JsonProperty("roleName")
    private String roleName;

    @JsonProperty("forceName")
    private String forceName;

    @JsonProperty("avatarUrl")
    private String avatarUrl;

    @JsonProperty("rankNum")
    private String rankNum;

    @JsonProperty("score")
    private String score;

    @JsonProperty("upNum")
    private String upNum;

    @JsonProperty("winRate")
    private String winRate;
}

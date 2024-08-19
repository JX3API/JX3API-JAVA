package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 站点标识
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class TokenWebTokenData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("user")
    private String user;

    @JsonProperty("token")
    private String token;

    @JsonProperty("servers")
    private List<String> servers;

    @JsonProperty("address")
    private String address;

    @JsonProperty("level")
    private Integer level;

    @JsonProperty("limit")
    private Long limit;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("delete")
    private String delete;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("datetime")
    private String datetime;
}

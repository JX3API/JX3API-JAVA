package jx3api.api.http.data.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Grafie
 * @since 2024/9/25  14:30
 */
@Data
public class RoleShowRandomData {
    @JsonProperty("server")
    private String server;
    @JsonProperty("name")
    private String name;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("status")
    private Integer status;
}

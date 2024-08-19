package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 资历榜单
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class SchoolSeniorityData {
    @JsonProperty("name")
    private String name;

    @JsonProperty("role")
    private String role;

    @JsonProperty("school")
    private String school;

    @JsonProperty("server")
    private String server;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("value")
    private Long value;

    @JsonProperty("avatar")
    private String avatar;
}

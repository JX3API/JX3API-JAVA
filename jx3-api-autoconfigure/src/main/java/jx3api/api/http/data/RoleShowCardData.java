package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 角色名片
 *
 * @author Grafie
 * @since 2024/9/25  14:24
 */
@Data
public class RoleShowCardData {
    @JsonProperty("zone")
    private String zone;
    @JsonProperty("server")
    private String server;
    @JsonProperty("global")
    private String global;
    @JsonProperty("name")
    private String name;
    @JsonProperty("static")
    private String staticUrl;
    @JsonProperty("cache")
    private String cache;


    public void setCache(Long cache) {
        this.cache = TimeUtils.timeFormatting(cache);
    }
}

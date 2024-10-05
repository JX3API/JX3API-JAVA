package jx3api.api.http.data.valuables.collect;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

@Data
public class DropData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("name")
    private String name;

    @JsonProperty("role_name")
    private String roleName;

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("time")
    private String time;

    public void setTime(long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

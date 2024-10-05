package jx3api.api.http.data.role.teamcd;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CdInfo {
    @JsonProperty("mapIcon")
    private String mapIcon;
    @JsonProperty("mapId")
    private String mapId;
    @JsonProperty("mapName")
    private String mapName;
    @JsonProperty("mapType")
    private String mapType;
    @JsonProperty("bossCount")
    private Integer bossCount;
    @JsonProperty("bossFinished")
    private Integer bossFinished;
    @JsonProperty("bossProgress")
    private List<BossProgressInfo> bossProgress;
}

package jx3api.api.http.data.server.sand;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CastleInfo {
    @JsonProperty("tongId")
    private Integer tongId;

    @JsonProperty("tongName")
    private String tongName;

    @JsonProperty("castleId")
    private Integer castleId;

    @JsonProperty("castleName")
    private String castleName;

    @JsonProperty("masterId")
    private Integer masterId;

    @JsonProperty("masterName")
    private String masterName;

    @JsonProperty("campId")
    private Integer campId;

    @JsonProperty("campName")
    private String campName;
}

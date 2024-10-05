package jx3api.api.http.data.duowan.statistical;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DuowanInfo {
    @JsonProperty("campName")
    private String campName;

    @JsonProperty("sid")
    private int sid;

    @JsonProperty("logoUrl")
    private String logoUrl;

    @JsonProperty("users")
    private int users;

    @JsonProperty("snick")
    private String snick;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("logo")
    private int logo;

    @JsonProperty("asid")
    private int asid;
}

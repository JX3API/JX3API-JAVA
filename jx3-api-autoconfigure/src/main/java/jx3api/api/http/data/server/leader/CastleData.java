package jx3api.api.http.data.server.leader;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

@Data
public class CastleData {
    @JsonProperty("server")
    private String server;

    @JsonProperty("leader")
    private String leader;

    @JsonProperty("camp_name")
    private String campName;

    @JsonProperty("castle")
    private String castle;

    @JsonProperty("status")
    private int status;

    @JsonProperty("str_status")
    private String strStatus;

    @JsonProperty("start_time")
    private String startTime;

    @JsonProperty("end_time")
    private String endTime;

    public void setStartTime(long startTime) {
        this.startTime = TimeUtils.timeFormatting(startTime);
    }

    public void setEndTime(long endTime) {
        this.endTime = TimeUtils.timeFormatting(endTime);
    }
}

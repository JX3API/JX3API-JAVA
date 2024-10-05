package jx3api.api.http.data.member.recruit;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

import java.util.List;

/**
 * 团队招募
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MemberRecruitData {
    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("time")
    public String time;

    public void setTime(Long time) {
        this.time = TimeUtils.timeFormatting(time);
    }

    @JsonProperty("data")
    private List<ActivityInfo> data;
}


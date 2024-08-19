package jx3api.api.http.data;

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

@Data
class ActivityInfo {
    @JsonProperty("crossServer")
    private Boolean crossServer;

    @JsonProperty("activityId")
    private Integer activityId;

    @JsonProperty("activity")
    private String activity;

    @JsonProperty("level")
    private Integer level;

    @JsonProperty("leader")
    private String leader;

    @JsonProperty("pushId")
    private Integer pushId;

    @JsonProperty("roleId")
    private Integer roleId;

    @JsonProperty("createTime")
    private String createTime;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("maxNumber")
    private Integer maxNumber;

    @JsonProperty("label")
    private List<Object> label;

    @JsonProperty("content")
    private String content;

    public void setCreateTime(Long createTime) {
        this.createTime = TimeUtils.timeFormatting(createTime);
    }

}

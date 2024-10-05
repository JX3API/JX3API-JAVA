package jx3api.api.http.data.member.recruit;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

import java.util.List;

@Data
public class ActivityInfo {
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

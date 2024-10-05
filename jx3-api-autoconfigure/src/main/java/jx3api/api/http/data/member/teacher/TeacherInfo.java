package jx3api.api.http.data.member.teacher;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

@Data
public class TeacherInfo {

    @JsonProperty("roleId")
    private Integer roleId;

    @JsonProperty("roleName")
    private String roleName;

    @JsonProperty("roleLevel")
    private Integer roleLevel;

    @JsonProperty("campName")
    private String campName;

    @JsonProperty("tongName")
    private String tongName;

    @JsonProperty("tongMasterName")
    private String tongMasterName;

    @JsonProperty("bodyId")
    private Integer bodyId;

    @JsonProperty("bodyName")
    private String bodyName;

    @JsonProperty("forceId")
    private Integer forceId;

    @JsonProperty("forceName")
    private String forceName;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("time")
    private String time;

    public void setTime(long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

package jx3api.api.http.data.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

import java.util.List;

/**
 * 徒弟列表
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MemberStudentData {

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("data")
    private List<StudentInfo> data;

}

@Data
class StudentInfo {
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

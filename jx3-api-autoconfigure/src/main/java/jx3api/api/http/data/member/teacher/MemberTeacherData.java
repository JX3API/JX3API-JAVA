package jx3api.api.http.data.member.teacher;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 师父列表
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MemberTeacherData {
    @JsonProperty("zone")
    private String zone;
    @JsonProperty("server")
    private String server;

    @JsonProperty("data")
    private List<TeacherInfo> data;
}


package jx3api.api.http.data.member.student;

import com.fasterxml.jackson.annotation.JsonProperty;
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


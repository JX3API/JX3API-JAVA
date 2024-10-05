package jx3api.api.http.data.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author grafie
 * @since 2024/6/23  16:05
 */
@Data
public class SchoolToxicData {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("class")
    private String classType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("toxic")
    private String toxic;
    @JsonProperty("attribute")
    private String attribute;
    @JsonProperty("status")
    private String status;
    @JsonProperty("datetime")
    private String dateTime;
}

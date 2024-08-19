package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 名剑统计
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MatchSchoolsData {
    @JsonProperty("last")
    private Integer last;

    @JsonProperty("name")
    private String name;

    @JsonProperty("this")
    private Integer current;
}

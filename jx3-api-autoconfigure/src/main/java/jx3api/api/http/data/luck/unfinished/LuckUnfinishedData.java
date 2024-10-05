package jx3api.api.http.data.luck.unfinished;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 未出奇遇
 * @author Grafie
 * @since 2024/9/25  10:20
 */
@Data
public class LuckUnfinishedData {
    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("last")
    private Last last;
}

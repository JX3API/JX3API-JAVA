package jx3api.api.http.data.active.monster;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

import java.util.List;

/**
 * 百战首领
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ActiveMonsterData {
    @JsonProperty("start")
    private String start;
    @JsonProperty("end")
    private String end;
    @JsonProperty("data")
    private List<MonsterInfo> data;

    public void setStart(Long start) {
        this.start = TimeUtils.timeFormatting(start);
    }

    public void setEnd(Long end) {
        this.end = TimeUtils.timeFormatting(end);
    }
}


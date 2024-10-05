package jx3api.api.http.data.active;

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

@Data
class MonsterInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("skill")
    private List<String> skill;

    @JsonProperty("level")
    private String level;

    @JsonProperty("data")
    private OtherData data;
}

@Data
class OtherData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("list")
    private List<String> list;

    @JsonProperty("desc")
    private String description;

    @JsonProperty("time")
    private String time;

    public void setTime(Long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

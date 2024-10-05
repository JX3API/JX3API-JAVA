package jx3api.api.http.data.active.monster;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

import java.util.List;

@Data
public class OtherData {
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

package jx3api.api.http.data.luck.collect;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

@Data
public class CatData {
    @JsonProperty("name")
    private String name;

    @JsonProperty("time")
    public String time;

    public void setTime(Long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

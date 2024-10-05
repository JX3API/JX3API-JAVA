package jx3api.api.http.data.active.monster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MonsterInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("skill")
    private List<String> skill;

    @JsonProperty("level")
    private String level;

    @JsonProperty("data")
    private OtherData data;
}

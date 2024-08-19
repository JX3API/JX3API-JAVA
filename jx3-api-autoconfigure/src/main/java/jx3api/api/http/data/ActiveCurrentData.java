package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 活动日历返回值
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ActiveCurrentData {

    @JsonProperty("date")
    private String date;

    @JsonProperty("week")
    private String week;

    @JsonProperty("war")
    private String war;

    @JsonProperty("battle")
    private String battle;

    @JsonProperty("orecar")
    private String orecar;

    @JsonProperty("school")
    private String school;

    @JsonProperty("rescue")
    private String rescue;

    @JsonProperty("draw")
    private String draw;

    @JsonProperty("leader")
    private List<String> leader;

    @JsonProperty("team")
    private List<String> team;

    @JsonProperty("luck")
    private List<String> luck;

    @JsonProperty("card")
    private List<String> card;

}

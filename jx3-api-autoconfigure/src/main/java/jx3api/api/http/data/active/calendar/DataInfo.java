package jx3api.api.http.data.active.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DataInfo {
    @JsonProperty("date")
    private String date;
    @JsonProperty("day")
    private String day;
    @JsonProperty("week")
    private String week;
    @JsonProperty("war")
    private String war;
    @JsonProperty("year")
    private String year;
    @JsonProperty("month")
    private String month;
    @JsonProperty("battle")
    private String battle;
    @JsonProperty("orecar")
    private String orecar;
    @JsonProperty("school")
    private String school;
    @JsonProperty("rescue")
    private String rescue;
    @JsonProperty("luck")
    private List<String> luck;
    @JsonProperty("card")
    private List<String> card;
}

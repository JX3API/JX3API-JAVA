package jx3api.api.http.data.active;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * active_calendar
 *
 * @author Grafie
 * @since 2024/6/19  10:38
 */
@Data
public class ActiveCalendarData {
    /**
     * 日期
     */
    @JsonProperty("today")
    private Today today;
    /**
     * 数据
     */
    @JsonProperty("data")
    private List<DataInfo> data;
}

@Data
class Today {
    @JsonProperty("date")
    private String date;
    @JsonProperty("week")
    private String week;
    @JsonProperty("year")
    private String year;
    @JsonProperty("month")
    private String month;
    @JsonProperty("day")
    private String day;
}

@Data
class DataInfo {
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

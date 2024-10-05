package jx3api.api.http.data.active.calendar;

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


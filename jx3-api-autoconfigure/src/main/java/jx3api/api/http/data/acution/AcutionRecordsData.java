package jx3api.api.http.data.acution;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 拍卖记录
 *
 * @author Grafie
 * @since 2024/9/25  14:17
 */
@Data
public class AcutionRecordsData {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("zone")
    private String zone;
    @JsonProperty("server")
    private String server;
    @JsonProperty("role_name")
    private String roleName;
    @JsonProperty("camp_name")
    private String campName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("time")
    private String time;

    public void setTime(Long time) {
        this.time = TimeUtils.timeFormatting(time);
    }
}

package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 阵营事件
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ServerEventData {
    @JsonProperty("id")
    private int id;

    @JsonProperty("camp_name")
    private String campName;

    @JsonProperty("fenxian_zone_name")
    private String fenxianZoneName;

    @JsonProperty("fenxian_server_name")
    private String fenxianServerName;

    @JsonProperty("friend_zone_name")
    private String friendZoneName;

    @JsonProperty("friend_server_name")
    private String friendServerName;

    @JsonProperty("role_name")
    private String roleName;

    @JsonProperty("set_time")
    private String addTime;

    public void setAddTime(long addTime) {
        this.addTime = TimeUtils.timeFormatting(addTime);
    }
}

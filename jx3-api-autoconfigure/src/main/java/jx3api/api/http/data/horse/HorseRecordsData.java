package jx3api.api.http.data.horse;

import com.fasterxml.jackson.annotation.JsonProperty;
import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 的卢统计
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class HorseRecordsData {
    @JsonProperty("id")
    private int id;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("name")
    private String name;

    @JsonProperty("level")
    private int level;

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("refresh_time")
    private String refreshTime;

    @JsonProperty("capture_role_name")
    private String captureRoleName;

    @JsonProperty("capture_camp_name")
    private String captureCampName;

    @JsonProperty("capture_time")
    private String captureTime;

    @JsonProperty("auction_role_name")
    private String auctionRoleName;

    @JsonProperty("auction_camp_name")
    private String auctionCampName;

    @JsonProperty("auction_time")
    private String auctionTime;

    @JsonProperty("auction_amount")
    private String auctionAmount;

    @JsonProperty("start_time")
    private String startTime;

    @JsonProperty("end_time")
    private String endTime;

    public void setAuctionTime(long auctionTime) {
        this.auctionTime = TimeUtils.timeFormatting(auctionTime);
    }

    public void setCaptureTime(long captureTime) {
        this.captureTime = TimeUtils.timeFormatting(captureTime);
    }

    public void setEndTime(long endTime) {
        this.endTime = TimeUtils.timeFormatting(endTime);
    }

    public void setRefreshTime(long refreshTime) {
        this.refreshTime = TimeUtils.timeFormatting(refreshTime);
    }

    public void setStartTime(long startTime) {
        this.startTime = TimeUtils.timeFormatting(startTime);
    }
}

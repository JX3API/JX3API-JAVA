package jx3api.api.http.data.home;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 器物图谱
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class HomeTravelData {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private int type;

    @JsonProperty("color")
    private int color;

    @JsonProperty("source")
    private String source;

    @JsonProperty("architecture")
    private int architecture;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("quality")
    private int quality;

    @JsonProperty("view")
    private int view;

    @JsonProperty("practical")
    private int practical;

    @JsonProperty("hard")
    private int hard;

    @JsonProperty("geomantic")
    private int geomantic;

    @JsonProperty("interesting")
    private int interesting;

    @JsonProperty("produce")
    private String produce;

    @JsonProperty("image")
    private String image;

    @JsonProperty("tip")
    private String tip;
}

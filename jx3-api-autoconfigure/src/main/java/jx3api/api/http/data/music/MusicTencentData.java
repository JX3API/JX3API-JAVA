package jx3api.api.http.data.music;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 腾讯音乐
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MusicTencentData {
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("singer")
    private String singer;
}

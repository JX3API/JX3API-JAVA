package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 网易音乐
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MusicNeteaseData {
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("singer")
    private String singer;
}

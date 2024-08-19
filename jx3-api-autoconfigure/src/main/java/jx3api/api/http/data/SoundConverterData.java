package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 语音合成
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class SoundConverterData {
    @JsonProperty("text")
    private String text;

    @JsonProperty("token")
    private String token;

    @JsonProperty("url")
    private String url;
}

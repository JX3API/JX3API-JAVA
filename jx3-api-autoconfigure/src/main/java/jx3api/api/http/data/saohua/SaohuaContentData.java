package jx3api.api.http.data.saohua;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 舔狗日记
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class SaohuaContentData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("text")
    private String text;
}

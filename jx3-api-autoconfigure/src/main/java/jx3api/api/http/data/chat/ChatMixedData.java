package jx3api.api.http.data.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 智障聊天
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class ChatMixedData {
    @JsonProperty("id")
    private String id;

    @JsonProperty("answer")
    private String answer;
}

package jx3api.api.http.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 挂件效果
 * @author jinpeng.chen
 * @since 2024/9/25  10:10
 */
@Data
public class TableRecordsData {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("class")
    private String clazz;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ui")
    private String ui;
    @JsonProperty("source")
    private String source;
    @JsonProperty("desc")
    private String desc;
}

package jx3api.api.http.data.movie.editor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 动画编辑
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class MovieEditorData {
    @JsonProperty("name")
    private String name;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("view")
    private String view;

    @JsonProperty("data")
    private List<HairstyleData> data;

}


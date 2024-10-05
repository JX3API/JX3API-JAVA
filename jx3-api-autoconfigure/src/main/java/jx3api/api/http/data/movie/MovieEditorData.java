package jx3api.api.http.data.movie;

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

@Data
class HairstyleData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("mesh1")
    private String mesh1;

    @JsonProperty("mesh2")
    private String mesh2;

    @JsonProperty("match_hair1")
    private String matchHair1;

    @JsonProperty("match_hair2")
    private String matchHair2;

    @JsonProperty("sfx1")
    private String sfx1;

    @JsonProperty("sfx2")
    private String sfx2;

    @JsonProperty("outward_id")
    private Integer outwardId;
}

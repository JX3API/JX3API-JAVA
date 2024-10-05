package jx3api.api.http.data.role.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PanelList {
    @JsonProperty("score")
    private int score;

    @JsonProperty("panel")
    private List<PanelItem> panel;
}

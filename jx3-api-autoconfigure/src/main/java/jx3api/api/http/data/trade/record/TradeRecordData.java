package jx3api.api.http.data.trade.record;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 物品价格
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class TradeRecordData {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("class")
    private String classType;

    @JsonProperty("subclass")
    private String subclass;

    @JsonProperty("name")
    private String name;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("subalias")
    private String subalias;

    @JsonProperty("raw")
    private String raw;

    @JsonProperty("level")
    private Integer level;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("view")
    private String view;

    @JsonProperty("date")
    private String date;

    @JsonProperty("data")
    private List<List<SaleData>> data;
}


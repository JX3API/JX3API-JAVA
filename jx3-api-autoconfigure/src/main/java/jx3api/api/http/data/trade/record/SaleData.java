package jx3api.api.http.data.trade.record;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SaleData {
    @JsonProperty("id")
    private String id;

    @JsonProperty("index")
    private Integer index;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("server")
    private String server;

    @JsonProperty("value")
    private Integer value;

    @JsonProperty("sales")
    private Integer sales;

    @JsonProperty("token")
    private String token;

    @JsonProperty("source")
    private Integer source;

    @JsonProperty("date")
    private String date;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("datetime")
    private String datetime;

}

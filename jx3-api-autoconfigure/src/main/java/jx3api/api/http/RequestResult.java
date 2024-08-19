package jx3api.api.http;

import lombok.Data;

import java.util.Map;

/**
 * 最外层返回值
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class RequestResult {
    /**
     * 返回状态值
     */
    private Integer code;
    /**
     * 提示内容
     */
    private String msg;
    /**
     * 实际返回值
     */
    private Object data;
    /**
     * 时间戳
     */
    private Long time;
}

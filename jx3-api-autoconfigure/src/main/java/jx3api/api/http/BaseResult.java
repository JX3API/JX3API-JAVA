package jx3api.api.http;

import lombok.Data;

/**
 * @author jinpeng.Chen
 * @since 2024/6/23  11:54
 */
@Data
public class BaseResult<T> {
    /**
     * 服务返回的错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 转换后的值
     */
    private T data;
}

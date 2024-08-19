package jx3api.api.ws.data;

import jx3api.api.util.TimeUtils;
import lombok.Data;

/**
 * 基础ws变量
 *
 * @author Grafie
 * @since 1.0.0
 */
@Data
public class BaseWsData {
    /*
     * 绝大部分消息里面都有以下值，故放到基础类，部分事件无此相关字段的话，请忽略
     * */
    /**
     * ws事件的actionCode
     */
    private Integer action;
    /**
     * 剑网三 大区
     */
    private String zone;
    /**
     * 剑网三 服务器
     */
    private String server;
    /**
     * 时间
     */
    private String time;

    public void setTime(Long time) {
        if (time == null) {
            return;
        }
        this.time = TimeUtils.timeFormatting(time);
    }

}

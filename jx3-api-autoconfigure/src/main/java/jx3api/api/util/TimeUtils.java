package jx3api.api.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 时间工具类
 *
 * @author Grafie
 * @since 1.0.0
 */
public class TimeUtils {

    /**
     * 时间格式化参数
     */
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 默认的时间戳格式化工具类
     *
     * @param timestamp 时间戳，接口数据默认是截止到秒的时间戳
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String timeFormatting(long timestamp) {
        if (timestamp <= 0) {
            return "";
        }
        // 默认使用Asia/Shanghai,毕竟剑三也不会用别的时区
        LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("Asia/Shanghai"));
        return time.format(DATETIME_FORMATTER);
    }

    /**
     * 获取当前时间字符串
     *
     * @return 时间字符串 yyyy-MM-dd HH:mm:ss
     */
    public static String getNowString() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }
}

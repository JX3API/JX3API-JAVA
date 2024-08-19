package jx3api.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * ws配置相关类
 *
 * @author Grafie
 * @since 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "jx3api.ws")
@Data
@Conditional(OnEnableJX3ApiWSCondition.class)
public class WebSocketProperties {
    /**
     * wsToken，ws有些接口需要校验你的token
     */
    private String wsToken;
    /**
     * wsUrl
     */
    private String wsUrl;
    /**
     * 重新连接次数.如果为空，则默认5000
     */
    private Integer reConnectMaxTimes = 5000;
    /**
     * ws数据解析默认包地址，可以为空
     */
    private List<String> wsDataBeanBasePackage;

}

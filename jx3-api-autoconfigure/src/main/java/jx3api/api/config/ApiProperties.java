package jx3api.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Api相关配置信息
 *
 * @author Grafie
 * @since 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "jx3api.api")
@Data
@Conditional(OnEnableJX3ApiHttpCondition.class)
public class ApiProperties {
    /**
     * api访问地址, 如果为空，则默认 https://www.jx3api.com
     */
    private String apiUrl = "https://www.jx3api.com";
    /**
     * api访问token，有些api接口，需要校验你的token
     */
    private String apiToken;
}

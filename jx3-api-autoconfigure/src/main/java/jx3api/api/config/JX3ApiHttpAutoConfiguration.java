package jx3api.api.config;

import jakarta.annotation.Resource;
import jx3api.api.http.ApiService;
import jx3api.api.ws.IWsDataPushService;
import jx3api.api.ws.WebSocketClientInitializer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自动装配类
 *
 * @author Grafie
 * @since 1.0.0
 */
@Configuration
@Conditional(OnEnableJX3ApiHttpCondition.class)
public class JX3ApiHttpAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(JX3ApiHttpAutoConfiguration.class);

    @Resource
    private ApiProperties apiProperties;



    @Bean
    public ApiService apiService() {
        if (StringUtils.isBlank(apiProperties.getApiUrl())) {
            throw new NullPointerException("jx3api url 不允许为空，请检查配置信息");
        }
        if (StringUtils.isBlank(apiProperties.getApiToken())) {
            logger.error("未获取到ApiToken，付费接口将无法使用");
        }
        logger.info("欢迎使用JX3 API Java sdk http API");
        return new ApiService(apiProperties);
    }
}

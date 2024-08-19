package jx3api.api.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用JX3Api所有模块
 *
 * @author Grafie
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@EnableJX3ApiHttp
@EnableJX3ApiWS
public @interface EnableJX3Api {

}

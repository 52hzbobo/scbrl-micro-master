package com.scbrl.feign.configuration;

import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 模块:【自定义Feign配置】
 * <p>
 * 开发: Bruce.Liu By 2017/11/24 下午8:19 Create
 */
@Deprecated
//@Configuration
public class FooConfiguration {

    /**
     * Feign 日志配置
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.INFO;
    }
}

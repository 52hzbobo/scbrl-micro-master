package com.scbrl.config;

import com.scbrl.interceptor.FeignRequestInterceptor;
import feign.Feign;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 模块:【Feign配置项（请求拦截）】
 * <p>
 * 开发: Bruce.Liu By 2017/11/25 下午5:11 Create
 * <p>
 * 参考: 自定义feign配置与服务调用的安全验证
 *       http://www.jianshu.com/p/755b15ff0249
 */
@Configuration
@ConditionalOnClass({Feign.class})
@ConditionalOnProperty(value = "feign.oauth2.enabled", matchIfMissing = true)
public class FeignAutoConfiguration {

    @Bean
    public RequestInterceptor feignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }
}

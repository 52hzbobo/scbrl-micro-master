package com.scbrl.interceptor;

import com.scbrl.util.MD5Util;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 模块:【FeignClient的请求拦截器】
 * <p>
 * 开发: Bruce.Liu By 2017/11/25 下午5:06 Create
 * <p>
 * 参考: http://yyq2007aa.blog.163.com/blog/static/4418160920171945658790/
 */
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    public FeignRequestInterceptor() {
    }

    @Override
    public void apply(RequestTemplate template) {
        try {
            String timestamp = System.currentTimeMillis()+"";
            template.header("timestamp",timestamp);
            template.header("sign", MD5Util.RestfulSign(timestamp,
                    InetAddress.getLocalHost().getHostAddress()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

package com.scbrl.interceptor;

import com.scbrl.util.MD5Util;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;

/**
 * 模块:【FeignClient的请求拦截器】
 * <p>
 * 开发: Bruce.Liu By 2017/11/25 上午10:35 Create
 *
 * TODO: 已弃用 ，新版本请参考：FeignRequestInterceptor
 */
//@Component
@Deprecated
public class FeignUserAgentInterceptor {// implements Interceptor {

    /**
     * FeignClient请求加上默认请求头（签名、时间轴）
     * @param chain
     * @return
     * @throws IOException
     */
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        try {
//            Request request = chain.request();
//            Headers headers = request.headers();
//            String timestamp = System.currentTimeMillis()+"";
//            headers.newBuilder().add("timestamp",timestamp);
//            headers.newBuilder().add("sign", MD5Util.RestfulSign(timestamp,
//                    InetAddress.getLocalHost().getHostAddress()));
//            Response response = chain.proceed(request);
//            return response;
//        } catch (Exception e) {
//            throw e;
//        } finally {
//
//        }
//    }

}

package com.scbrl;

import com.scbrl.interceptor.FeignUserAgentInterceptor;
import com.scbrl.interceptor.RestUserAgentInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@Slf4j
public class ScbrlWebApplication {

	/**
	 * 实例化restTemplate
	 * 并使其拥有Ribbon负载均衡能力
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectionRequestTimeout(15);
		httpRequestFactory.setConnectTimeout(15);
		httpRequestFactory.setReadTimeout(15);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters()
				.add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		restTemplate.setInterceptors(Collections.singletonList(new RestUserAgentInterceptor()));
		return restTemplate;
	}


//	@Bean
//	@ConditionalOnBean(FeignUserAgentInterceptor.class)
//	public OkHttpClient okHttpClient(@Autowired FeignUserAgentInterceptor feignUserAgent){
//		OkHttpClient.Builder ClientBuilder = new OkHttpClient.Builder()
//				.readTimeout(30, TimeUnit.SECONDS) //读取超时
//				.connectTimeout(10, TimeUnit.SECONDS) //连接超时
//				.writeTimeout(60, TimeUnit.SECONDS) //写入超时
//				.connectionPool(new ConnectionPool(10 /*maxIdleConnections*/, 3, TimeUnit.MINUTES))
//				.addInterceptor(feignUserAgent);
//		return ClientBuilder.build();
//	}



	public static void main(String[] args) {

		SpringApplication.run(ScbrlWebApplication.class, args);
		log.info("[------------------- >>> SpringBootApplication Main Start In ScbrlApplication <<< -------------------]" );
	}


}

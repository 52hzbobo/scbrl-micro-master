package com.scbrl;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.scbrl.mapper")
@Slf4j
public class ScbrlProviderApplication {

	public static void main(String[] args) {

		SpringApplication.run(ScbrlProviderApplication.class, args);
		log.info("[------------------- >>> SpringBootApplication Main Start In 【Provider】 <<< -------------------]" );
	}


}

package com.scbrl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
@Slf4j
public class ScbrlEurekaApplication {

	public static void main(String[] args) {

		SpringApplication.run(ScbrlEurekaApplication.class, args);
		log.info("[------------------- >>> SpringBootApplication Main Start In 【Eureka】 <<< -------------------]" );
	}


}

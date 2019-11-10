package com.pp.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
@MapperScan("com.pp.server.Dao")
public class EUserApplication {

	public static void main(String[] args) {
		SpringApplication.run( EUserApplication.class, args);
	}

}


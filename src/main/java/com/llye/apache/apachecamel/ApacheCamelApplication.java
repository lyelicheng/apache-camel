package com.llye.apache.apachecamel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.llye.apache.apachecamel.mapper")
public class ApacheCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheCamelApplication.class, args);
	}

}
;
package com.ro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import com.ro.demo.config.SwaggerConfiguration;


@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class SpringBootAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularApplication.class, args);
	}

}

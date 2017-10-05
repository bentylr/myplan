package com.love;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"com.love.config", "com.love.controller", "com.love.dao", "com.love.service"})
public class MyplanApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MyplanApplication.class, args);
	}
}

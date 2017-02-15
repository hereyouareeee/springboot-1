package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
@Slf4j
public class SpringbootApplication {

	@RequestMapping("/")
	public String home(){
		return "hello world";
	}

	public static void main(String[] args) {
		log.info("启动了");
		SpringApplication.run(SpringbootApplication.class, args);
	}
}

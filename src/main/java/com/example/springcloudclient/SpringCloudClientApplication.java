package com.example.springcloudclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
@ComponentScan
@EnableAutoConfiguration
public class SpringCloudClientApplication {

	@Value("${key1}")
	private String key1;

	@Value("${key2}")
	private String key2;

	@Value("${key_dev}")
	private String key_dev;


	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClientApplication.class, args);
	}

	@PostMapping(value = "/get")
	public String getKey() {
		return key1 + "==" + key2 + "==" + key_dev ;
	}
}

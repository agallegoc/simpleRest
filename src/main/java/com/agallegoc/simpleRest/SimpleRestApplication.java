package com.agallegoc.simpleRest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleRestApplication {

	@Value("${CF_INSTANCE_GUID:not_set}")
	String cfInstance;

	@Value("${HOSTNAME:not_set}")
	String hostname;

	private String getHostName(){

		if(!hostname.equals("not_set")) return hostname;
		if(!cfInstance.equals("not_set")) return cfInstance;
		return "no_host_info";

	}

	@GetMapping("/hello")
	String hello(){

		return getHostName()+": Hello, bootiful world! (v1) ";
	}

	@GetMapping("/fail")
	String fail() {

		System.exit(0);
		return "fixed!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestApplication.class, args);
	}

}


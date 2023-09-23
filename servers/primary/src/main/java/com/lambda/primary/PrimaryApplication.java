package com.lambda.primary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PrimaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimaryApplication.class, args);
	}

	@GetMapping("ping/")
	public String ping(){
		return "success";
	}

}

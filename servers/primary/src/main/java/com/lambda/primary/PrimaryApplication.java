package com.lambda.primary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EntityScan({
		"com.lambda.primary.CoreExports.entities",
		"com.lambda.primary.ContentExports.entities"
})
public class PrimaryApplication {



	public static void main(String[] args) {
		SpringApplication.run(PrimaryApplication.class, args);
	}


}

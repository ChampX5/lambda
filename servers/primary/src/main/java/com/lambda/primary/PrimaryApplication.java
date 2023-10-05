package com.lambda.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.convert.ConversionService;

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

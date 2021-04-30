package com.iamslash.exbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class ExbatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExbatchApplication.class, args);
	}

}

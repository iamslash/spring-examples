package com.iamslash.exjpa;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ExJpaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(ExJpaApplication.class)
				.run(args);
	}

}

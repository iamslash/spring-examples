package com.iamslash.exmeetup;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ExmeetupApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(ExmeetupApplication.class)
				.run(args);
	}

}

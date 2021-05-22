package com.iamslash.exsecurity;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ExsecurityApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(ExsecurityApplication.class)
				.run(args);
	}

}

package com.iamslash.excore;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ExcoreApplication {

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(ExbasicApplication.class);
//		app.setBanner(((environment, sourceClass, out) -> {
//			out.println("==================================================");
//			out.println("I' am david sun.");
//			out.println("==================================================");
//		}));
//		app.setBannerMode(Banner.Mode.CONSOLE);
//		app.run(args);
		new SpringApplicationBuilder()
				.sources(ExcoreApplication.class)
				.run(args);
	}

}

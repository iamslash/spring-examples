package com.iamslash.exbasic;

import org.apache.catalina.core.ApplicationContext;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ExbasicApplication {

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
				.sources(ExbasicApplication.class)
				.run(args);
	}

}

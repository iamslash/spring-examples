package com.iamslash.exconfig;

import com.iamslash.exconfig.config.AuthConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(AuthConfigProperties.class)
public class ExconfigApplication {

//	private static final Logger log = LoggerFactory.getLogger(ExconfigApplication.class);

	@Autowired
	AuthConfigProperties authConfigProperties;

	public static void main(String[] args) {
		SpringApplication.run(ExconfigApplication.class, args);
	}

	@PostConstruct
	public void print() {
		log.info("");
		log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		log.info("iamslash.authcookie: " + authConfigProperties.getAuthcookie());
		log.info("iamslash.authcookiesalt: " + authConfigProperties.getAuthcookieSalt());
		log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}

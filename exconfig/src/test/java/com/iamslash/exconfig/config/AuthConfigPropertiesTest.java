package com.iamslash.exconfig.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value=AuthConfigProperties.class)
@TestPropertySource("classpath:application-develop.properties")
class AuthConfigPropertiesTest {

  @Autowired
  private AuthConfigProperties authConfigProperties;

  @Test
  void getAuthcookie() {
    assertEquals("HelloWorld", authConfigProperties.getAuthcookie());
  }
}

# References

* [Guide to @ConfigurationProperties in Spring Boot](https://www.baeldung.com/configuration-properties-in-spring-boot)
  * [src](https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-properties)
* [Testing Spring Boot @ConfigurationProperties @ baeldung](https://www.baeldung.com/spring-boot-testing-configurationproperties)
  * [src](https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-testing)
* [23. Externalized Configuration @ spring-boot 1.2.2](https://docs.spring.io/spring-boot/docs/1.2.2.RELEASE/reference/html/boot-features-external-config.html)

# Externalized Configuration order

* Command line arguments.
* JNDI attributes from java:comp/env.
* Java System properties (System.getProperties()).
* OS environment variables.
* A RandomValuePropertySource that only has properties in random.*.
* Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants)
* Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants)
* Application properties outside of your packaged jar (application.properties and YAML variants).
* Application properties packaged inside your jar (application.properties and YAML variants).
* @PropertySource annotations on your @Configuration classes.
* Default properties (specified using SpringApplication.setDefaultProperties).

# @ConfigurationProperties

Create a `src/main/resources/application-develop.properties`

```
iamslash.authcookie: HelloWorld
iamslash.authcookieSalt: HelloWorld
```

Create a mapping class `src/main/java/com/iamslash/exconfig/config/FooSetting.java`

```java
@ConfigurationProperties(prefix = "iamslash")
public class AuthConfigProperties {
  private String authcookie;
  private String authcookieSalt;

  public String getAuthcookie() {
    return authcookie;
  }
  public void setAuthcookie(String authcookie) {
    this.authcookie = authcookie;
  }
  public String getAuthcookieSalt() {
    return authcookieSalt;
  }
  public void setAuthcookieSalt(String authcookieSalt) {
    this.authcookieSalt = authcookieSalt;
  }
}
```

Add `@EnableConfiguration` to `src/main/java/com/iamslash/exconfig/ExApplication`.

```java
@SpringBootApplication
@EnableConfigurationProperties(AuthConfigProperties.class)
public class Application { ... }
```

And Use `AuthConfigProperties` with `@Autowired`.

```java
@SpringBootApplication
@EnableConfigurationProperties(AuthConfigProperties.class)
public class ExconfigApplication {

	@Autowired
	AuthConfigProperties authConfigProperties;

	public static void main(String[] args) {
		SpringApplication.run(ExconfigApplication.class, args);
	}

	@PostConstruct
	public void print() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("iamslash.authcookie: " + authConfigProperties.getAuthcookie());
		System.out.println("iamslash.authcookiesalt: " + authConfigProperties.getAuthcookieSalt());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}
```

# Test of `@EnableConfigurationProperties`

Add `src/test/java/com.iamslash.exconfig.config.AuthConfigPropertiesTest.java`

```java
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
```

* @ExtendWith – integrates Spring's TestContext framework with JUnit5
* @EnableConfigurationProperties – enables support for @ConfigurationProperties beans (in this case, the AuthConfigProperties bean)
* @TestPropertySource – specifies a testing file that overrides the default application.properties file

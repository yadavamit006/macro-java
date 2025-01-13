https://spring.io/guides/gs/testing-web

@Configuration: Tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

@ComponentScan: Tells Spring to look for other components, configurations, and services in the package where your annotated TestingWebApplication class resides (com.example.testingweb), letting it find the com.example.testingweb.HelloController.

@SpringBootTest annotation tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context.


@MockMvc : is not part of Mockito. MockMvc is a class provided by the Spring Test framework specifically for testing Spring MVC controllers.


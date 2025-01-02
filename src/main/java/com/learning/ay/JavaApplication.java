package com.learning.ay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JavaApplication {
	//code for all
	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

}

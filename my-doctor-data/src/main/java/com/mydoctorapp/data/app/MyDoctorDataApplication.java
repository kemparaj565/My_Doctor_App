package com.mydoctorapp.data.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.mydoctorapp.data.bean")
@ComponentScan(basePackages="com.mydoctorapp.data")
@EnableJpaRepositories("com.mydoctorapp.data")
public class MyDoctorDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDoctorDataApplication.class, args);
		
	}

}

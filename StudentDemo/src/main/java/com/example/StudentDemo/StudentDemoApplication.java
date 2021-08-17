package com.example.StudentDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = {"com.example.Model"})
@ComponentScan(basePackages = {"com.example.StudentDemo.repository"})
@ComponentScan(basePackages = {"com.example.StudentDemo.service"})
@ComponentScan(basePackages= {"com.example.StudentDemo.controller"})

public class StudentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDemoApplication.class, args);
	}

}

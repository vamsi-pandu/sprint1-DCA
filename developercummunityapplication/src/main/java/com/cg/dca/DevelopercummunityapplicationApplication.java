package com.cg.dca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication     //  makes possible to get different data from application based on URL from client side
@EnableSwagger2            //  Indicates that Swagger support should be enabled
                           //  swagger is to test application in any normal browser

@ComponentScan(basePackages = "com")  //  scans the beans from the given base package name
@CrossOrigin(origins = "http://localhost:4200")
public class DevelopercummunityapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopercummunityapplicationApplication.class, args);
	}
	//SpringApplication.run(): Starts Spring,  creates  Spring context , applies annotations and  sets up embedded container 

}

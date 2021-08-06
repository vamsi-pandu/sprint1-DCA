package com.cg.dca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com")
public class DevelopercommunityappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopercommunityappApplication.class, args);
	}

}

package com.sim.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sim.app.controller"))
				// .paths(regex("/user.*"))
				.paths(PathSelectors.any()).build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Sim Card Management", "Sim Card Management", "2.0",
				"Terms of service",
				new Contact("Krishna Srikarla", "https://www.SimCardManagement.com", "hr@SimCardManagement.com"),
				"Sim Card Management License Version 2.0", "https://www.SimCardManagement.com");
		return apiInfo;
	}
}
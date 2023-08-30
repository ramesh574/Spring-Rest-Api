package com.ramesh.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title = "Spring Boot Rest API Documentation",
				description = "Spring Boot Rest API Documentation",
				version ="v1.2.0",
				contact = @Contact(
						name="Ramesh Prajapati",
						email = "ramesh12@gmail.com",
						url = "http://www.google.com"
				),
				license = @License(
                 name = "Apache 10.0",
						url = "http://www.ramesh.com/license"
				)
		),
				externalDocs = @ExternalDocumentation(
						description = "Spring Boot User Management Documentation",
						url = "https://www.ramesh.com/user.html"
				)

)

public class SpringRestfullApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestfullApplication.class, args);
	}

}

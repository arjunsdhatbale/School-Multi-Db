package com.main;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name = "Arjun",
						email = "arjundhatbale321@gmail.com",
						url = "http://localhost:8081/index.html"
						),
				description = "This is open api configuration.",
				title = "Swagger for API Testing",
				version = "v1.0"
		)
)
@SecurityScheme(
		name = "Basic Authenticaiton",
		description = "Username and password ",
		scheme = "basic",
		type = SecuritySchemeType.DEFAULT
		)
public class OpenApiConfig {

}

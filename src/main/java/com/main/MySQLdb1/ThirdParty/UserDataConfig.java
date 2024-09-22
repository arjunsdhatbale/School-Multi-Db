package com.main.MySQLdb1.ThirdParty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserDataConfig {

	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}
}

package com.main.MySQLdb1.ThirdParty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDataService {

	@Autowired
	private RestTemplate restTemplate ;

	public UserData getData() {
		// TODO Auto-generated method stub
		return  restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", UserData.class);
	} 
}

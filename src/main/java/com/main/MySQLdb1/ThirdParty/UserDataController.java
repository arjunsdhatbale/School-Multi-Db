package com.main.MySQLdb1.ThirdParty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserDataController {

	@Autowired
	private UserDataService userDataService;
	
	@Autowired
	private UserDataRepo userDataRepo;
	
	@GetMapping("/third")
	public ResponseEntity<UserData> getData(){
		
		UserData data = this.userDataService.getData();
		UserData save = this.userDataRepo.save(data);
		return new ResponseEntity<UserData>(data,HttpStatus.OK);
		
	}
	
	 
}

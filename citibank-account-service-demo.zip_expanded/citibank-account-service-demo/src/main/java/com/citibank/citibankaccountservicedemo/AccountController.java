package com.citibank.citibankaccountservicedemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // registers this object in the spring container
@RequestMapping("/account") // entry point to this webservice
public class AccountController {

	@Value("${server.port}") // injects server.port value present in the property file to the port variable
	private String port; 
	
	@GetMapping(path = "/balance")
	public ResponseEntity<Object> getBalance() {
		// we are generating a dummy account information along with port number
		Map<String, Object> map = new HashMap<>();
		map.put("balance", Double.valueOf(Math.random() * 12345).doubleValue());
		map.put("port", port);
		return ResponseEntity.status(200).body(map);
	}
}

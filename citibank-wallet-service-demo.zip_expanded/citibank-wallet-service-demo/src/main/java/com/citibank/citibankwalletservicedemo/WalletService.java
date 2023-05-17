package com.citibank.citibankwalletservicedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// should use RestTemplate present in spring container & call Account microservice
@Service // registers the object as a service in spring container
public class WalletService {

	// use @Autowired to let spring to supply RestTemplate
	@Autowired // spring supplies RestTemplate object to this property
	private RestTemplate rest; // this object can send request using GET, POST, PUT, DELETE
	
	// method that sends request to remote service
	public Wallet initializeWallet() {
		String url = "http://AMS/account/balance";
		// Request = Get http://AMS/account/balance 
		// Response = { "port", "balance"}
		Wallet wallet = rest.getForObject(url, Wallet.class); // initializes port & balance of Wallet
		wallet.setWalletNumber(Double.valueOf(wallet.getBalance() * 31).intValue());
		wallet.setDescription("Account Microservice is running in port: "+wallet.getPort());
		return wallet;
	}
}

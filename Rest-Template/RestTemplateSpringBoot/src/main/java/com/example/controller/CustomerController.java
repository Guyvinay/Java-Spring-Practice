package com.example.controller;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Customer;
import com.example.model.LoginBean;

@RestController
public class CustomerController {

	@PostMapping("/getAllCustomers")
	public List<Customer> signInCustomer(@RequestBody LoginBean bean){
		
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		
		
		RestTemplate restTemplate = restTemplateBuilder.basicAuthentication(bean.getUsername(), bean.getPassword()).build();
		
		String url = "http://localhost:8080/signIn";

		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		 
		String token = responseEntity.getHeaders().getFirst("Authorization");
		 
		
		String url2="http://localhost:8080/customers";
		 
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization","Bearer " +token);
		
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		
		ResponseEntity<List<Customer>> responseEntity2 = restTemplate.exchange(url2 , HttpMethod.GET , httpEntity , new ParameterizedTypeReference<List<Customer>>(){});
		List<Customer> body = responseEntity2.getBody();
		System.out.println(body);
		return body;
	}
	
}

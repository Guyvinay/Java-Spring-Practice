package com.masai.RestTemplateMaven;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTempClass {

	private static String baseUrl = "http://localhost:8080/signIn";
	private static String getCusUrl = "http://localhost:8080/customers";

	@Autowired
	private RestTemplate restTemplate;
	
	public void getEmployee(int id) {
		ResponseEntity<EmployeeDTO> responseEntity = 
				restTemplate.getForEntity(baseUrl+"/"+id, EmployeeDTO.class);
		EmployeeDTO body = responseEntity.getBody();
		System.out.println(body);
	}
	
	public void registerEmployee(EmployeeDTO emp) {
		
		ResponseEntity<EmployeeDTO> responseEntity = restTemplate.postForEntity(baseUrl,emp , EmployeeDTO.class);
		
		EmployeeDTO body = responseEntity.getBody();
		
		HttpStatusCode statusCode = responseEntity.getStatusCode();
		HttpHeaders headers = responseEntity.getHeaders();
		System.out.println(headers.entrySet());
		System.out.println(statusCode.toString());
		System.out.println(body);
		
	}
	
	
	public void callingSecureAPI(String email , String pass) {
			
	String base64 = Base64.getEncoder()
			      .encodeToString((email+":"+pass).getBytes());
	
	HttpHeaders headers = new HttpHeaders();
	headers.add("Authorization", "Basic "+base64);
//	headers.setBasicAuth(email, pass);
	
	HttpEntity<String> request = new HttpEntity<>(headers);
	
	ResponseEntity<String> responseEntity = 
			restTemplate.exchange(
					baseUrl, 
					HttpMethod.GET, 
					request, 
					String.class);
	
	String body = responseEntity.getBody();
	String token = responseEntity.getHeaders().getFirst("Authorization");
	System.out.println(token);
	
	HttpHeaders headers2 = new HttpHeaders();
	headers2.setBearerAuth(token);
	HttpEntity<String> req2 = new HttpEntity<>(headers2);
	
	ResponseEntity<List<Customer>> exchange = restTemplate.exchange( getCusUrl , HttpMethod.GET , req2 ,new ParameterizedTypeReference<List<Customer>>() {});
	
	List<Customer> list = exchange.getBody();
	
	System.out.println(list);
	
	}
}

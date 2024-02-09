package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.modal.Category;
import com.app.modal.Entity;
import com.app.modal.Entry;
import com.app.modal.ResponseDTO;
import com.app.service.AppService;

@RestController
@RequestMapping(value = "/api")
public class AppController {

	private static String baseUrl = "https://api.publicapis.org";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AppService appService;
	
	@GetMapping(value = "/categories")
	public ResponseEntity<Category> getCategories(){
		
		return new ResponseEntity<Category>(appService.getCategories(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/entries/{category}")
	public ResponseEntity<List<Entry>> getEntriesByCategory(@PathVariable("category") String category){
		
		return new ResponseEntity<List<Entry>>(appService.getEntriesByCategory(category), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(value = "/resources")
	public ResponseEntity<ResponseDTO> fetchUrl(){
		ResponseEntity<ResponseDTO> responseEntity = restTemplate
				.getForEntity(baseUrl+"/entries", ResponseDTO.class);
		
		return responseEntity;
	}
	@GetMapping(value = "/random")
	public ResponseEntity<Entity> saveRandomEntry(){

		return new ResponseEntity<Entity>(appService.saveRandomEntry(), HttpStatus.ACCEPTED);
	}
}

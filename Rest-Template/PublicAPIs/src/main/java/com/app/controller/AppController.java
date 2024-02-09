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

	private static final String baseUrl = "https://api.publicapis.org";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AppService appService;

	//To fetch all actual categories
	@GetMapping(value = "/categories")
	public ResponseEntity<Category> getCategories(){
		
		return new ResponseEntity<Category>(appService.getCategories(), HttpStatus.ACCEPTED);
	}

	//Getting entries with category
	@GetMapping(value = "/entries/{category}")
	public ResponseEntity<List<Entry>> getEntriesByCategory(@PathVariable("category") String category){
		
		return new ResponseEntity<List<Entry>>(appService.getEntriesByCategory(category), HttpStatus.ACCEPTED);
	}
	

	//getting all entries
	@GetMapping(value = "/resources")
	public ResponseEntity<ResponseDTO> fetchUrl(){

        return restTemplate
				.getForEntity(baseUrl+"/entries", ResponseDTO.class);
	}

	//getting one random entry and save in database
	@GetMapping(value = "/save_random_entry")
	public ResponseEntity<Entity> saveRandomEntry(){

		return new ResponseEntity<Entity>(appService.saveRandomEntry(), HttpStatus.ACCEPTED);
	}
}

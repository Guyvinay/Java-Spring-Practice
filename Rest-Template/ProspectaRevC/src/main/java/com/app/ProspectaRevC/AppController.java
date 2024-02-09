package com.app.ProspectaRevC;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.modal.Entities;
import com.app.modal.Entry;
import com.app.modal.ReqDTO;
import com.app.modal.RespDTO;
import com.app.repository.AppRepository;
import com.app.service.AppService;

@RestController
public class AppController {

	
	private static String baseUrl="https://api.publicapis.org";
	
	@Autowired
	private RestTemplate restTemplate;
//	
//	@Autowired
//	AppRepository appRepository;
	
//	@Autowired 
//	private AppService appService;
	
	@GetMapping(value = "/hi")
	public String sayHI() {
		return "Hello";
	}
	
	@GetMapping(value = "/resources")
	public ResponseEntity<RespDTO> getAllResp(){
		
		ResponseEntity<RespDTO> responseEntity = restTemplate
				.getForEntity(baseUrl+"/entries", RespDTO.class);
		
		return responseEntity;
	}
	
	@GetMapping(value = "/resources/{category}")
	public ResponseEntity<List<ReqDTO>> getAllRespByCate(
			@PathVariable("category") String category
			){
		
		
		List<ReqDTO> list = new ArrayList<>();
		
		
		ResponseEntity<RespDTO> responseEntity = restTemplate
				.getForEntity(baseUrl+"/entries", RespDTO.class);
		
		
		List<Entry> entries = responseEntity
				.getBody().getEntries();
		
		for(Entry ent : entries) {
			if(ent.getCategory().equalsIgnoreCase(category))
				list.add(new ReqDTO(ent.getAPI() , ent.getDescription()));
		}
		
		return new ResponseEntity<List<ReqDTO>>(list , HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "resources/random")
	public ResponseEntity<Entities> getRandomEntry(){
		
		ResponseEntity<RespDTO> responseEntity = restTemplate
				.getForEntity(baseUrl+"/random", RespDTO.class);
		
		Entry entry = responseEntity.getBody().getEntries().get(0);
		Entities entities = new Entities(
				entry.getAPI() , 
				entry.getDescription(),
				entry.getAuth() ,
				entry.getHTTPS(),
				entry.getCors(),
				entry.getLink(),
				entry.getCategory()
				);
		
		return new ResponseEntity<Entities>(entities , HttpStatus.ACCEPTED);
	}
	
	
}

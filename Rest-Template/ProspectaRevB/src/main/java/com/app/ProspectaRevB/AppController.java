package com.app.ProspectaRevB;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.modal.DTOReq;
import com.app.modal.DTOResp;
import com.app.modal.Entities;
import com.app.modal.Entry;
import com.app.repo.DbRepository;

@RestController
public class AppController {
	
	@Autowired
	RestTemplate restTemplate;

//	@Autowired
//	DbRepository dbRepository;
	
	
	private static String baseUrl = "https://api.publicapis.org";
	
	@GetMapping(value = "/hi")
	public String sayHi() {
		return "Hii";
	}
	
	@GetMapping(value = "/app")
	public ResponseEntity<DTOResp> getResp(){
		
		List<DTOReq> ansList = new ArrayList<>();
		
		ResponseEntity<DTOResp> responseEntity = restTemplate.getForEntity(baseUrl+"/entries", DTOResp.class);
		
		
		
		return responseEntity ;
		
	}
	
	
	@GetMapping(value = "/app/{category}")
	public ResponseEntity<List<DTOReq>> getRespByCategory(@PathVariable("category")String category){
		
		List<DTOReq> ansList = new ArrayList<>();
		
		ResponseEntity<DTOResp> responseEntity = restTemplate
				.getForEntity(baseUrl+"/entries", DTOResp.class);
		
		List<Entry> list = responseEntity.getBody().getEntries();
		
		for( Entry ent : list ) {
			ansList.add(new DTOReq(ent.getAPI(), ent.getDescription()));
		}
		
		return new ResponseEntity<List<DTOReq>>(ansList, HttpStatus.ACCEPTED) ;
		
	}
	
	@GetMapping(value = "/saveEntry")
	public ResponseEntity<Entities> saveEntry(){
		
		ResponseEntity<DTOResp> responseEntity = restTemplate
				.getForEntity(baseUrl+"/random", DTOResp.class);
		
		Entry entry = responseEntity.getBody().getEntries().get(0);
		
		Entities ent = new Entities(entry.getAPI(), 
				entry.getAuth(), 
				entry.getCategory(), 
				entry.getCors(), 
				entry.getDescription(), 
				entry.getHTTPS(), 
				entry.getLink());
		return new ResponseEntity<Entities>(ent, HttpStatus.ACCEPTED);
	}
}

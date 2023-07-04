package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Modal.Content;
import com.masai.Modal.User;
import com.masai.Service.HotStartSerImpl;

@RestController
public class HotStartController {

	@Autowired
	private HotStartSerImpl hotStartSerImpl;
	
	@PostMapping(value = "/users")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		
		return new ResponseEntity<User>(hotStartSerImpl.registerUser(user) , HttpStatus.ACCEPTED);
		
	}
	@PostMapping(value = "/contents")
	public ResponseEntity<Content> addContent(@RequestBody Content content){
		return new ResponseEntity<Content>(hotStartSerImpl.addContent(content) , HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value = "/contents")
	public ResponseEntity<List<Content>> browseContent(){
		
		return new ResponseEntity<List<Content>>(hotStartSerImpl.browseContent() , HttpStatus.OK);
	}
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> browseUsers(){
		
		return new ResponseEntity<List<User>>(hotStartSerImpl.browseUsers() , HttpStatus.OK);
	}

	@PatchMapping(value = "/users/{userId}/{contentId}")
	public ResponseEntity<User> chooseContentToStream(@PathVariable Integer userId , @RequestBody Content content){
		
		return new ResponseEntity<User>(hotStartSerImpl.chooseContentToStream(userId, content.getContentId()) , HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<List<Content>> provideRecommendations(@PathVariable Integer userId ){
		return new ResponseEntity<List<Content>>(hotStartSerImpl.provideRecommendations(userId), HttpStatus.OK);
		
	}
	
	
}

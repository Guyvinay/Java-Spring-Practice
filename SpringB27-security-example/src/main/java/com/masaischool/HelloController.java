package com.masaischool;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/simple")
	public String simpleHello() {
		User user = (User)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return "From simple message";
	}
	
	@GetMapping("/no_login_needed")	//you can given naming pattern
	public String simpleNoLogin() {
		return "I am accessible without making login";
	}
	
	@PostMapping("/posts")
	public ResponseEntity<String> posts(@RequestBody Map<String, Object> map) {
		return new ResponseEntity<String>("Record Added successfully", HttpStatus.CREATED);
	}
	
}

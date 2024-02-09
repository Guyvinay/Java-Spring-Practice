package com.masai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.SwiggyException;
import com.masai.model.Customer;
import com.masai.model.DeliveryPartner;
import com.masai.model.Orders;
import com.masai.model.Resturant;
import com.masai.model.User;
import com.masai.repository.UserRepository;
import com.masai.service.SwiggyService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SwiggyController {

	@Autowired
	private SwiggyService service ;
	
	@Autowired
	private UserRepository cRepo;
	
	@Autowired
	private PasswordEncoder pc ;
	
	@PostMapping("/costomers")
	public ResponseEntity<Customer> saveCustomerHandler(@Valid @RequestBody Customer c){
		log.info("cutomers api got called");
		c.setPassword(pc.encode(c.getPassword())) ;
		return new ResponseEntity<Customer>(service.addCustomer(c) , HttpStatus.CREATED) ;
	}
	
	@PostMapping("/devPan")
	public ResponseEntity<DeliveryPartner> saveDPHandler(@RequestBody DeliveryPartner c){
		return new ResponseEntity<DeliveryPartner>(service.addDP(c) , HttpStatus.CREATED) ;
	}
	
	@PostMapping("/rest")
	public ResponseEntity<Resturant> saveResHandler(@RequestBody Resturant c){
		return new ResponseEntity<Resturant>(service.addRest(c) , HttpStatus.CREATED) ;
	}
	
	@PostMapping("/costomers/{cId}/{rId}/{dId}")
	public ResponseEntity<Orders> saveCustomerHandler(@RequestBody Orders c , @PathVariable Integer cId , @PathVariable Integer rId , @PathVariable Integer dId ){
		return new ResponseEntity<Orders>(service.giveOrder(c, cId, rId, dId) , HttpStatus.CREATED) ;
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getOrders( ){
		return new ResponseEntity<List<Orders>>(service.getOrder() , HttpStatus.OK) ;
	}
	
	
	
	@GetMapping("/logini")
	public ResponseEntity<String> logInUserHandler(Authentication auth){
		 Optional<User> opt= cRepo.findByUsername(auth.getName());
		 if(opt.isEmpty()) throw new SwiggyException("No user found") ;
		 User user = opt.get();
		 return new ResponseEntity<>(user.getUsername()+" Logged In Successfully", HttpStatus.ACCEPTED);
	}
}

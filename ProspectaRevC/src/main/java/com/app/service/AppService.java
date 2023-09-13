package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.modal.Entities;
import com.app.repository.AppRepository;

@Service
public class AppService {

	@Autowired
	AppRepository appRepository;
	
	public Entities getRandomEntry(Entities ents){
		return appRepository.save(ents);	
	} 
}

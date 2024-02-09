package com.masai.Entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class GymManager {

	@Autowired
	private Map<WorkoutProgram, Member> gymPrograms = new HashMap<WorkoutProgram, Member>();

	public GymManager() {
		super();
		
	}
	@PostConstruct
	public void intiMethod() {
		System.out.println("Init");
		
	}
	@PreDestroy
	public void destroyMethod() {
		
		System.out.println("Destroy");
		
	}
	public void putValue(WorkoutProgram wp, Member mem) {
		gymPrograms.put(wp, mem);
	}
	public void showDetails()
	{	
		for(Map.Entry<WorkoutProgram, Member> ent : gymPrograms.entrySet()) {
			System.out.println(ent.getKey()+" "+ ent.getValue());
		}
	}
}

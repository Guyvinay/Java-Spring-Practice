package com.masai;

public class MyService {
	
	private Database db;

	public MyService() {
		super();
	}

	public MyService(Database db) {
		super();
		this.db = db;
	}
	
	public void connStart() {
		
		db.getConnection();
		
	}
	
}

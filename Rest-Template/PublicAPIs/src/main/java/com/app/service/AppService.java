package com.app.service;

import java.util.List;

import com.app.modal.Category;
import com.app.modal.Entity;
import com.app.modal.Entry;

public interface AppService {

	public Category getCategories();
	
	public List<Entry> getEntriesByCategory(String category);
	
	public Entity saveRandomEntry();
}

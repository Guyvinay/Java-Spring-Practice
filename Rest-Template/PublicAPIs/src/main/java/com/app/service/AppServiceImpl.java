package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.exception.NotFoundException;
import com.app.modal.Category;
import com.app.modal.Entity;
import com.app.modal.Entry;
import com.app.modal.ResponseDTO;
import com.app.repository.AppRepository;

@Service
public class AppServiceImpl implements AppService {

	private static String baseUrl = "https://api.publicapis.org";

	@Autowired
	private AppRepository appRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Category getCategories() {
		ResponseEntity<Category> responseEntity = restTemplate.getForEntity(baseUrl + "/categories", Category.class);

		return responseEntity.getBody();
	}

	@Override
	public List<Entry> getEntriesByCategory(String category) {

		ResponseEntity<ResponseDTO> responseEntity = restTemplate.getForEntity(baseUrl + "/entries", ResponseDTO.class);

		if (!responseEntity.getStatusCode().is2xxSuccessful())
			throw new NotFoundException("Extraction Failed!!!");

		ResponseDTO responseDTO = responseEntity.getBody();

		if (responseDTO.getEntries().isEmpty())
			throw new NotFoundException("Entires Not Found!!!");
		List<Entry> collect = responseDTO.getEntries().stream()
				.filter((e) -> e.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());

		if (collect.isEmpty())
			throw new NotFoundException("Entries with category: " + category + ", not found!!!");

		return collect;
	}

	@Override
	public Entity saveRandomEntry() {
		ResponseEntity<ResponseDTO> responseEntity = restTemplate.getForEntity(baseUrl + "/random", ResponseDTO.class);

		if (!responseEntity.getStatusCode().is2xxSuccessful())
			throw new NotFoundException("Extraction Failed!!!");

		Entry body = responseEntity.getBody().getEntries().get(0);

		if (body == null)
			throw new NotFoundException("Entry Not Found!!!");

		return appRepository.save(new Entity(body.getAPI(), body.getDescription(), body.getLink(), body.getCategory()));
	}

}

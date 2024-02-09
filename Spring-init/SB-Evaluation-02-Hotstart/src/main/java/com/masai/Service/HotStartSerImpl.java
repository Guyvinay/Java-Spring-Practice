package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Modal.Content;
import com.masai.Modal.User;
import com.masai.Reop.HotStartRepoImpl;

@Service
public class HotStartSerImpl implements HotStartService{

	@Autowired
	private HotStartRepoImpl hotStartRepoimpl;

	@Override
	public User registerUser(User user) {
		
		return hotStartRepoimpl.registerUser(user);
	}

	@Override
	public Content addContent(Content content) {
	
		return hotStartRepoimpl.addContent(content);
	}

	@Override
	public List<Content> browseContent() {
		
		return hotStartRepoimpl.browseContent();
				
	}

	@Override
	public List<User> browseUsers() {
		
		return hotStartRepoimpl.browseUsers();
	}

	@Override
	public User chooseContentToStream(int userId, int contentId) {
		
		return hotStartRepoimpl.chooseContentToStream(userId, contentId);
	}

	@Override
	public List<Content> provideRecommendations(int userId) {
		// TODO Auto-generated method stub
		return hotStartRepoimpl.provideRecommendations(userId);
	}
	
}

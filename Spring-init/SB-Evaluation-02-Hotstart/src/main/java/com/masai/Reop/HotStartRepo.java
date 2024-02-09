package com.masai.Reop;

import java.util.List;

import com.masai.Modal.Content;
import com.masai.Modal.User;

public interface HotStartRepo {

	public User registerUser(User user);
	public Content addContent(Content content);
	public List<Content> browseContent();
	public List<User> browseUsers();
	public User chooseContentToStream(int userId , int contentId);
	public List<Content> provideRecommendations(int userId);
	
}

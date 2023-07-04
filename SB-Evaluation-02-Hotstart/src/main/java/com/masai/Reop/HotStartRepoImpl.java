package com.masai.Reop;

//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.masai.Exception.NotFoundException;
import com.masai.Modal.Content;
import com.masai.Modal.User;

import jakarta.annotation.PostConstruct;

@Repository
public class HotStartRepoImpl implements HotStartRepo{

//	private Set<User> userSet ;
//	private Set<Content> contentSet;
	private Map<Integer , User> userSet;
	private Map<Integer , Content> contentSet;
	
	@PostConstruct
	public void postCOnstruct() {
		
//		userSet = new TreeSet<>();
//		contentSet = new TreeSet<>();
//		
//		userSet.add(new User(1, "ABC", "abc@gmail.com"));
//		userSet.add(new User(2, "BCD", "bcd@gmail.com"));
//		userSet.add(new User(3, "DEF", "def@gmail.com"));
//		
//		contentSet.add(new Content(1, "Avatar", "the way of Water", 2.5));
//		contentSet.add(new Content(2, "KingsMan", "Secret Sevice", 2.0));
//		contentSet.add(new Content(3, "Avengers", "Endgame", 2.1));
//		contentSet.add(new Content(4, "Mission Impossible", "Ghost Protocol", 2.3));
		
		userSet = new TreeMap<>();
		contentSet = new TreeMap<>();
		
		User user1 = new User(1, "ABC", "abc@gmail.com");
		User user2 = new User(2, "BCD", "bcd@gmail.com");
		User user3 = new User(3, "DEF", "def@gmail.com");
		
		userSet.put(1,user1);
		userSet.put(2,user2);
		userSet.put(3,user3);
		
		Content cont1 = new Content(1, "Avatar", "the way of Water", 2.5);
		Content cont2 = new Content(2, "KingsMan", "Secret Sevice", 2.0);
	    Content cont3 = new Content(3, "Avengers", "Endgame", 2.1);
		Content cont4 = new Content(4, "Mission Impossible", "Ghost Protocol", 2.3);
		
		contentSet.put(1,cont1);
		contentSet.put(2,cont2);
		contentSet.put(3,cont3);
		contentSet.put(4,cont4);
//		
		user1.getContentSet().add(cont1);
		user1.getContentSet().add(cont3);
//		
		user2.getContentSet().add(cont2);
		user2.getContentSet().add(cont4);
		
		user3.getContentSet().add(cont1);
		user3.getContentSet().add(cont2);
		
		
	}

	
	
	@Override
	public User registerUser(User user) {
		if(user==null) throw new NotFoundException("Cannot Null");
//		
//		User user2 = userSet.stream().filter(a->a.getUserId()==user.getUserId()).toList().get(0);
//		
		if(userSet.containsKey(user.getUserId())) throw new NotFoundException("User Already Present");
		
		userSet.put(1,user);
		
		
		return user;
	}

	@Override
	public Content addContent(Content content) {
       if(content==null) throw new NotFoundException("Cannot Null");
//		Content cont = contentSet.stream().filter(a->a.getContentId()==content.getContentId()).toList().get(0);
//		if(cont !=null) throw new NotFoundException("Already Present");
		if(contentSet.containsKey(content.getContentId()))throw new NotFoundException("Already Present");
		contentSet.put(1,content);
		
		
		return content;
	}

	@Override
	public List<Content> browseContent() {
		if(contentSet.isEmpty()) throw new NotFoundException("No Content to show Present");
	     List<Content> set = new ArrayList<>();
	     for(Map.Entry<Integer, Content> ent : contentSet.entrySet()) {
	    	 set.add(ent.getValue());
	     }
		return set;
	}



	@Override
	public List<User> browseUsers() {
		if(userSet.isEmpty()) throw new NotFoundException("No User to show Present");
	     List<User> set = new ArrayList<>();
	     for(Map.Entry<Integer, User> ent : userSet.entrySet()) {
	    	 set.add(ent.getValue());
	     }
		return set;
	}



	@Override
	public User chooseContentToStream(int userId, int contentId) {
		
		User user = userSet.get(userId);
		Content content = contentSet.get(contentId);
		if(user == null) throw new NotFoundException("this user is not Registered");
		if(content == null) throw new NotFoundException("this Content is not Registered");
		user.getContentSet().add(content);
		return user;
	}



	@Override
	public List<Content> provideRecommendations(int userId) {
		User user = userSet.get(userId);
		if(user==null) throw new NotFoundException("No Recommendation For This User As this user is not Registered");
		Set<Content> conSet = user.getContentSet();
		List<Content> set = new ArrayList<>();
		for(Map.Entry<Integer, Content> cnt : contentSet.entrySet()) {
			set.add(cnt.getValue());
		}
		
		List<Content> contList = new ArrayList<>();
		contList.addAll(conSet);
		if(contList.isEmpty()) {
			contList = set;
		}
		
		return contList;
	}
	

	
    
	
	

}

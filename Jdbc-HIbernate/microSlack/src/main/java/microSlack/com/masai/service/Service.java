package microSlack.com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import microSlack.com.masai.model.Channel;
import microSlack.com.masai.model.Message;
import microSlack.com.masai.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private Repository repo ;
	
	
	public String addChannel(Channel channel) {
		return repo.addChannel(channel);
	}
	
	public String addMessage(Message message, Integer id) {
		return repo.addMessage(message , id);
	}
	
	public Channel getChannel(Integer id) {
		return repo.getChannel(id);
	}
	
	public Message getMessage(Integer id) {
		return repo.getMessage(id);
	}

}

package microSlack.com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;

import microSlack.com.masai.model.Channel;
import microSlack.com.masai.model.Message;
import microSlack.com.masai.service.Service;


@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private Service service;
	
	
	public String addChannel(Channel channel) {
		return service.addChannel(channel);
	}
	
	public String addMessage(Message message, Integer id) {
		return service.addMessage(message , id);
	}
	
	public Channel getChannel(Integer id) {
		return service.getChannel(id);
	}
	
	public Message getMessage(Integer id) {
		return service.getMessage(id);
	}

}

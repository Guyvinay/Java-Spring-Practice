package microSlack.com.masai.repository;

import java.util.HashMap;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import microSlack.com.masai.model.Channel;
import microSlack.com.masai.model.Message;


@org.springframework.stereotype.Repository
public class Repository {
	
	private Map<Integer, Channel > channelMap  = new HashMap<Integer, Channel>();
	private Map<Integer, Message> messageMap = new HashMap<Integer, Message>();
	
	@PostConstruct
	public void createWorkSpace() {
		//adding 1 channel and 1 message at the start of the application context.
		Channel channel = new Channel(1, "Default");
		Message message = new Message(1, "Hi, from Default channel");
		channel.getMessages().add(message);
		message.getChannels().add(channel);
		channelMap.put(1, channel);
		messageMap.put(1, message);
		
		System.out.println("Workspace got created");
		
	}
	
	public String addChannel(Channel channel) {
		if(channel == null) throw new RuntimeException("value is null");
		if(channelMap.get(channel.getChannelId()) != null ) throw new RuntimeException("id already present");
		channelMap.put(channel.getChannelId(), channel) ;
		return "channel added" ;
	}
	
	public String addMessage(Message message , Integer id) {
		if(message == null) throw new RuntimeException("value is null");
		if(messageMap.get(message.getMessageId()) != null ) throw new RuntimeException("id already present");
		Channel channel = channelMap.get(id);
		if(channel == null) throw new RuntimeException("No channel found");
		message.getChannels().add(channel);
		channel.getMessages().add(message);
		messageMap.put(message.getMessageId(), message);
		return "message added" ;
	}
	
	public Channel getChannel(Integer id) {
		Channel channel = channelMap.get(id);
		if(channel == null) throw new RuntimeException("No channel found");
		return channel;
	}
	
	public Message getMessage(Integer id) {
		Message message = messageMap.get(id);
		if(message == null) throw new RuntimeException("No channel found");
		return message;
	}
	
	@PreDestroy
	public void deleteWorkSpace() {
		//deleting all the channel and messages when application context will close.
		channelMap = new HashMap<Integer, Channel>();
		messageMap = new HashMap<Integer, Message>();
		System.out.println("Workspace got created");
		
	}
	
	
}

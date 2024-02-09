package microSlack.com.masai.model;

import java.util.ArrayList;
import java.util.List;

public class Message {

	private int messageId;
	private String message;
	private List<Channel> channels = new ArrayList<Channel>();
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	public Message(int messageId, String message) {
		super();
		this.messageId = messageId;
		this.message = message;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + "]";
	}
	
	
	
	
}

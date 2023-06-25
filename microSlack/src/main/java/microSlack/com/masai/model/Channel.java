package microSlack.com.masai.model;

import java.util.ArrayList;
import java.util.List;

public class Channel {

	private int channelId;
	private String channelName;
	private List<Message> messages = new ArrayList<Message>();
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public Channel(int channelId, String channelName) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
	}
	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", channelName=" + channelName + ", messages=" + messages + "]";
	}
	
	
	
	
	
}

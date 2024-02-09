package microSlack.com.masai.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import microSlack.com.masai.model.Channel;
import microSlack.com.masai.model.Message;
import microSlack.com.masai.util.Config;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class) ;
		Controller controller = ctx.getBean("controller" , Controller.class);
		System.out.println(controller);
		controller.addChannel(new Channel(2, "General")) ;
		System.out.println(controller.getChannel(1));
		controller.addMessage(new Message(2, "Hi, from General channel"), 1) ;
		System.out.println(controller.getMessage(1));
		System.out.println("message belongs to ");
		System.out.println(controller.getMessage(1).getChannels());
		((AnnotationConfigApplicationContext)ctx).close();
		// Now if I try to access any message or channel it will be empty.
//		System.out.println(controller.getChannel(1));
	}

}

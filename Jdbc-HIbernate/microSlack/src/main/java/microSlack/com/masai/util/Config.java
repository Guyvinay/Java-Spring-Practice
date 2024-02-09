package microSlack.com.masai.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import microSlack.com.masai.repository.Repository;

@Configuration
@ComponentScan("microSlack.com.masai")
public class Config {
	
	@Bean
	@Primary
	public Repository getRepo() {
		return new Repository() ;
	}

}

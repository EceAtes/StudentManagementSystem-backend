package com.testProject.ws;

import com.testProject.ws.user.User;
import com.testProject.ws.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WsApplication {

	public static void main(String[] args) {

		SpringApplication.run(WsApplication.class, args);
	}

	/*@Bean
	CommandLineRunner initialUsers(UserService us){
		return (args) -> {
			User user = new User();
			user.setUsername("user");
			user.setPassword("passwordTest");
			us.save(user);
		};
	}*/
}

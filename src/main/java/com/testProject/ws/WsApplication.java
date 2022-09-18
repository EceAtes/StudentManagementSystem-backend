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
/*
	@Bean
	CommandLineRunner initialUsers(UserService us){
		return (args) -> {
			for(int i = 0; i < 10; i++){
				User user = new User();
				user.setUsername("user" + i + 1);
				user.setPassword("passwordTest" + i + 1);
				user.setAccountType("admin");
				us.save(user);
			}
		};
	}*/
}

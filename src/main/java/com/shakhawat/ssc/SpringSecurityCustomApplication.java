package com.shakhawat.ssc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shakhawat.ssc.entity.User;
import com.shakhawat.ssc.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityCustomApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityCustomApplication.class, args);
	}
	
	@PostConstruct
	public void initData() {
		
		User[] locData = {new User("shakhawat", "$2a$12$yc.s1A1gLTeA90prtA81hOBUb2r67EHLiMquti1p0A.oy6kJHjA7W", "ADMIN"), 
				new User("alex", "$2a$12$/LaJtr7LOjKsHNkZ53wrQu//rGcEJ4qbwMpaWUmLacCw83.6Rx966", "USER")};
		
		// Here Bcrypt Hash of 123
		
		List<User> userList = Stream.of(locData).collect(Collectors.toList());
		
		userRepository.saveAll(userList);
		
	}

}

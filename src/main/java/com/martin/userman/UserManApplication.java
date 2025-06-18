package com.martin.userman;

import com.martin.userman.model.User;
import com.martin.userman.repository.UserRepository;
import com.martin.userman.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.martin.userman")
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EntityScan(basePackageClasses = User.class)
public class UserManApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManApplication.class, args);
	}

}

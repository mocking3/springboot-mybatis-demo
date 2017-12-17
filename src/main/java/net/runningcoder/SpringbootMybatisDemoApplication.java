package net.runningcoder;

import net.runningcoder.domain.User;
import net.runningcoder.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringbootMybatisDemoApplication implements CommandLineRunner {

	@Autowired
	private UserMapper userMapper;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisDemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User user = userMapper.findOne(1l);
		System.out.println(user.getId());
		List<User> users = userMapper.findAll();
		System.out.println(users.size());
		users = userMapper.findByCondition("admin");
		System.out.println(users.size());
	}
}

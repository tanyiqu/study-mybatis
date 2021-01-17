package love.tanyiqu;

import love.tanyiqu.mapper.UserMapper;
import love.tanyiqu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisSpringbootApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	void contextLoads() {
		List<User> users = userMapper.getUsers();

		for (User user : users) {
			System.out.println(user);
		}
	}

}

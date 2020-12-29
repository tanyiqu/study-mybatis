import com.tanyiqu.mapper.UserMapperImpl;
import com.tanyiqu.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {


    @Test
    public void getUsers() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapperImpl userMapperImpl = context.getBean("userMapperImpl", UserMapperImpl.class);

        List<User> users = userMapperImpl.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}

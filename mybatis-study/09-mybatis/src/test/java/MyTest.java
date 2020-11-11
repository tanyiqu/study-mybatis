import com.tanyiqu.mapper.UserMapper;
import com.tanyiqu.pojo.User;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void testCache1() {
        SqlSession session = MybatisUtil.getSqlSession();

        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        System.out.println("==============================");

        User user2 = mapper.queryUserById(2);
        System.out.println(user2);

        session.close();
    }
}
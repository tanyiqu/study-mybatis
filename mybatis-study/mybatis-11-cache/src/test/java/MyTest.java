import com.tanyiqu.mapper.UserMapper;
import com.tanyiqu.pojo.User;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testCache1() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println("============= cache 1 ============");
        List<User> users2 = userMapper.getUsers();
        for (User user : users2) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testCache2() {
        SqlSession sqlSession1 = MybatisUtil.getSqlSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        List<User> users1 = userMapper1.getUsers();
        for (User user : users1) {
            System.out.println(user);
        }
        sqlSession1.close();

        System.out.println();
        System.out.println("============= cache 2 ============");
        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        List<User> users2 = userMapper2.getUsers();
        for (User user : users2) {
            System.out.println(user);
        }
        sqlSession2.close();
    }

}

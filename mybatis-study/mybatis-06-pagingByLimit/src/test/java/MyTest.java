import com.tanyiqu.mapper.UserMapper;
import com.tanyiqu.pojo.User;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void getUsers() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }


    @Test
    public void getUsersByLimit() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", 2);
        map.put("pageSize", 2);

        List<User> users = userMapper.getUsersByLimit(map);

        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }


}

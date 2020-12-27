import com.tanyiqu.mapper.UserMapper;
import com.tanyiqu.pojo.User;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void findUserById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);

        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void findUserByIdWithResultMap() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserByIdWithResultMap(1);

        System.out.println(user);
        sqlSession.close();
    }


}

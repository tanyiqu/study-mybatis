package love.tanyiqu.mapper;

import love.tanyiqu.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> getUsers() {

        // 插入一个用户
        User user = new User(99, "test", "ttt");
        addUser(user);

        // 删除一个用户，因为SQL是错的，所有删除一定报错
        deleteUser(99);

        return getSqlSession().getMapper(UserMapper.class).getUsers();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}

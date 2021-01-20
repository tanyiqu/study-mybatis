package love.tanyiqu.mapper;

import love.tanyiqu.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();

    int addUser(User user);

    int deleteUser(int id);
}

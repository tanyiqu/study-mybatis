package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;

import java.util.List;
import java.util.Map;

public interface IUserMapper {
    // 查询所有用户
    List<User> getUsers();

    // 根据id查用户
    User getUserById(int id);

    // 添加一个用户
    int addUser(User user);

    int addUser2(Map<String, Object> map);

    // 修改用户
    int updateUser(User user);

    int updateUserPwd(Map<String, Object> map);

    // 删除用户
    int deleteUser(int id);
}
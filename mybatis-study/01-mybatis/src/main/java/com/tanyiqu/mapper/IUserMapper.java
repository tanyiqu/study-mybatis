package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;

import java.util.List;

public interface IUserMapper {
    // 查询所有用户
    List<User> getUsers();

    // 根据id查用户
    User getUserById(int id);

    // 添加一个用户
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);
}
package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface UserMapper {
    // 查询所有用户
    List<User> getUsers();

    // 添加用户
    int addUser(User user);

    // 删除用户
    int deleteUserById(@Param("id") int id);

    // 修改用户
    int updateUserById(@Param("id") int id);
}
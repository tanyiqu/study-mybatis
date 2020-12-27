package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface UserMapper {
    // 查询所有用户
    List<User> getUsers();


    User findUserById(@Param("id") int id);

    User findUserByIdWithResultMap(@Param("id") int id);

}
package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;

import java.util.List;

public interface UserMapper {
    // 查询所有用户
    List<User> getUsers();
}
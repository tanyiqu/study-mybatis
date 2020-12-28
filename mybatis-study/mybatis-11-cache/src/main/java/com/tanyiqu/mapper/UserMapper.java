package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询所有用户
    List<User> getUsers();
}
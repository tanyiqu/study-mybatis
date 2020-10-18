package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 根据id查用户
    User getUserById(int id);

}
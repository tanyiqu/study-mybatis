package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUserById(@Param("id") int id);
}

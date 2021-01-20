package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    public List<User> getUsers() {
        return getSqlSession().getMapper(UserMapper.class).getUsers();
    }
}

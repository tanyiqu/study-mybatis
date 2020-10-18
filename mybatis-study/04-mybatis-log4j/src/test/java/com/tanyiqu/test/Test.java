package com.tanyiqu.test;

import com.tanyiqu.mapper.UserMapper;
import com.tanyiqu.pojo.User;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class Test {

    @org.junit.Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(3);
        System.out.println(user);

        sqlSession.close();
    }

}

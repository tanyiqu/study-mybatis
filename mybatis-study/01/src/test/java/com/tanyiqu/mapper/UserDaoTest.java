package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

        List<User> users = userMapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}

package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void getUsers() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

        User user = userMapper.getUserById(4);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

        userMapper.addUser(new User(4,"张四","123654"));

        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

        userMapper.updateUser(new User(4,"张四","000000"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

        userMapper.deleteUser(4);

        sqlSession.commit();
        sqlSession.close();
    }

}

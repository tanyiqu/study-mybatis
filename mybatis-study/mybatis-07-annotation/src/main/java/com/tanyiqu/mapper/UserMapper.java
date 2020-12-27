package com.tanyiqu.mapper;

import com.tanyiqu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface UserMapper {
    // 查询所有用户
    @Select("select * from user")
    List<User> getUsers();

    // 根据ID查用户
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);

    // 根据ID删除用户
    @Delete("delete from user where id=#{id};")
    int deleteUserById(@Param("id") int id);

    // 添加用户
    @Insert("insert into user values(#{id},#{name},#{pwd})")
    int addUser(User user);

    // 修改用户密码为000000
    @Update("update user set pwd='000000' where id =#{id};")
    int updateUserById(@Param("id") int id);
}
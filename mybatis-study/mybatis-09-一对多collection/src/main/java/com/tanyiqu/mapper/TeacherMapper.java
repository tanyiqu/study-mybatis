package com.tanyiqu.mapper;

import com.tanyiqu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
//
//    List<Teacher> getTeachers();
//
//    Teacher getTeacherById(@Param("tid") int id);
//
//    Teacher getTeacherById2(@Param("tid") int id);

    // 根据id查询教师
    Teacher getTeacherById(@Param("tid") int id);

    // 查询所有教师
    List<Teacher> getTeachers();

    // 查询所有教师2
    List<Teacher> getTeachers2();

}

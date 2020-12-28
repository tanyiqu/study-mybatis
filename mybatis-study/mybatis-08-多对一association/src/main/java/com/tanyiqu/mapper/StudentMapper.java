package com.tanyiqu.mapper;

import com.tanyiqu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    // 查询学生和学生的教师
    Student getStudentById(@Param("sid") int id);

    // 查询所有学生和学生的教师
    List<Student> getStudents();

    List<Student> getStudents2();

}

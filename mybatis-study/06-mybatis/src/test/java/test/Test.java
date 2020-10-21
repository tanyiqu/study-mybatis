package test;

import com.tanyiqu.mapper.StudentMapper;
import com.tanyiqu.mapper.TeacherMapper;
import com.tanyiqu.pojo.Student;
import com.tanyiqu.pojo.Teacher;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    @org.junit.Test
    public void getTeachers() {
        SqlSession session = MybatisUtil.getSqlSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        session.close();
    }

    @org.junit.Test
    public void getStudents() {
        SqlSession session = MybatisUtil.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);



        session.close();
    }

}

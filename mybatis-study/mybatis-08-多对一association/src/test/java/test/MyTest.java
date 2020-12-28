package test;

import com.tanyiqu.mapper.StudentMapper;
import com.tanyiqu.mapper.TeacherMapper;
import com.tanyiqu.pojo.Student;
import com.tanyiqu.pojo.Teacher;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void getTeacherById() {
        SqlSession session = MybatisUtil.getSqlSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById(1);
        System.out.println(teacher);
        session.close();
    }


    @Test
    public void getStudentById() {
        SqlSession session = MybatisUtil.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student student = mapper.getStudentById(1);
        System.out.println(student);

        session.close();
    }

    @Test
    public void getStudents() {
        SqlSession session = MybatisUtil.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }

    @Test
    public void getStudents2() {
        SqlSession session = MybatisUtil.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents2();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }
}

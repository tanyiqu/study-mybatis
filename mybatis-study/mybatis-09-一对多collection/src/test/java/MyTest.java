import com.tanyiqu.mapper.TeacherMapper;
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
    public void getTeachers() {
        SqlSession session = MybatisUtil.getSqlSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        session.close();
    }


    @Test
    public void getTeachers2() {
        SqlSession session = MybatisUtil.getSqlSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeachers2();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        session.close();
    }

}
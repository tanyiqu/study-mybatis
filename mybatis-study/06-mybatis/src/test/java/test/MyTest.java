package test;

import com.tanyiqu.mapper.TeacherMapper;
import com.tanyiqu.pojo.Teacher;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void getTeacherById() {
        SqlSession session = MybatisUtil.getSqlSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById(1);
        System.out.println(teacher);
        session.close();
    }
}

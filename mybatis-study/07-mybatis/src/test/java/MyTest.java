import com.tanyiqu.mapper.TeacherMapper;
import com.tanyiqu.pojo.Teacher;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {


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
}

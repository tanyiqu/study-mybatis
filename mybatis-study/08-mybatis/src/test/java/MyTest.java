import com.tanyiqu.mapper.BlogMapper;
import com.tanyiqu.pojo.Blog;
import com.tanyiqu.util.IDUtil;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class MyTest {


    @Test
    public void addBlog(){
        SqlSession session = MybatisUtil.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        mapper.addBlog(new Blog(IDUtil.getUUid(),"Mybatis","Tanyiqu",new Date(),9999));
        mapper.addBlog(new Blog(IDUtil.getUUid(),"Java","Tanyiqu",new Date(),9999));
        mapper.addBlog(new Blog(IDUtil.getUUid(),"MySQL","Tanyiqu",new Date(),1000));
        mapper.addBlog(new Blog(IDUtil.getUUid(),"C++从入门到入土","Tanyiqu",new Date(),9999));

        session.commit();
        session.close();
    }
}

import com.tanyiqu.mapper.BlogMapper;
import com.tanyiqu.pojo.Blog;
import com.tanyiqu.util.IDUtil;
import com.tanyiqu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {


    @Test
    public void addBlog() {
        SqlSession session = MybatisUtil.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        mapper.addBlog(new Blog(IDUtil.getUUid(), "Mybatis", "Tanyiqu", new Date(), 9999));
        mapper.addBlog(new Blog(IDUtil.getUUid(), "Java", "Tanyiqu", new Date(), 9999));
        mapper.addBlog(new Blog(IDUtil.getUUid(), "MySQL", "Tanyiqu", new Date(), 1000));
        mapper.addBlog(new Blog(IDUtil.getUUid(), "C++从入门到入土", "Tanyiqu", new Date(), 9999));

        session.commit();
        session.close();
    }

    @Test
    public void queryBlogsByIf() {
        SqlSession session = MybatisUtil.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "Java");
        map.put("author", "Tanyiqu");

        List<Blog> blogs = mapper.queryBlogsByIf(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        session.close();
    }

    @Test
    public void queryBlogsByChoose() {
        SqlSession session = MybatisUtil.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "Java");

        List<Blog> blogs = mapper.queryBlogsByChoose(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        session.close();
    }

    @Test
    public void updateBlog() {
        SqlSession session = MybatisUtil.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", "06e53ae630eb45e088784f46fb3dfcb7");
//        map.put("title", "改了title");
        map.put("author", "改了author00");

        mapper.updateBlog(map);

        session.commit();
        session.close();
    }

}

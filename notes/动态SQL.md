# 动态SQL

## 准备

1.blog表

```sql
create table blog(
	id varchar(50) primary key,
	title varchar(100) not null ,
	author varchar(30) not null,
	create_time datetime not null,
	views int(30) not null
) engine=InnoDB default charset=utf8;
```



2.搭建mybatis环境

3.实体类

Blog.java

```java
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
    // 无参 和 全参构造 getter setter toString
}
```

4.ID工具类

IDUtil.java

```java
import java.util.UUID;

public class IDUtil {
    public static String getUUid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
```



# 常用标签

## IF标签

Mapper接口，BlogMapper.java

````java
List<Blog> queryBlogsByIf(Map<String, Object> map);
````



xml配置，BlogMapper.xml

```xml
<select id="queryBlogsByIf" parameterType="map" resultType="blog">
    select * from blog
    <where>
        <if test="title != null">
            title = #{title}
        </if>
        <if test="author != null">
            and author = #{author}
        </if>
    </where>
</select>
```



测试，MyTest.java

```java
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
```



## Choose标签

Mapper接口，BlogMapper.java

````java
List<Blog> queryBlogsByChoose(Map<String, Object> map);
````



xml配置，BlogMapper.xml

```xml
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
```



测试，MyTest.java

```java
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
```



## Set标签

Mapper接口，BlogMapper.java

````java
int updateBlog(Map<String, Object> map);
````



xml配置，BlogMapper.xml

```xml
<update id="updateBlog" parameterType="map">
    update blog
    <set>
        <if test="title != null">
            title = #{title},
        </if>
        <if test="author != null">
            author = #{author}
        </if>
    </set>
    where id = #{id}
</update>
```



测试，MyTest.java

```java
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
```


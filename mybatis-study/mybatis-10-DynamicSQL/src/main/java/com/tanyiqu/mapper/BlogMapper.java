package com.tanyiqu.mapper;

import com.tanyiqu.pojo.Blog;

import java.util.List;
import java.util.Map;

@SuppressWarnings("UnusedReturnValue")
public interface BlogMapper {

    int addBlog(Blog blog);

    List<Blog> queryBlogsByIf(Map<String, Object> map);

    List<Blog> queryBlogsByChoose(Map<String, Object> map);

    int updateBlog(Map<String, Object> map);

}

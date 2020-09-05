package com.hillstone.dao;

import com.hillstone.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);

    //查询Blog
    List<Blog> queryBlogIf(Map map);
    //使用SQL片段
    List<Blog> queryBlogIf2(Map map);

    List<Blog> queryBlogChoose(Map map);

    //更新Blog
    int updateBlog(Map map);

    //查询 1,2，3号的Blog
    List<Blog> queryBlogForeach(Map map);
}

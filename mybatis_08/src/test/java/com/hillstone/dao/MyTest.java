package com.hillstone.dao;

import com.hillstone.pojo.Blog;
import com.hillstone.utils.IDutils;
import com.hillstone.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    //插入数据
    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.close();
    }

     //查询Blog if
    @Test
    public void queryBlogIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","Spring");
       //map.put("author","狂神说");
        List<Blog> blogList = blogMapper.queryBlogIf(map);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    //查询Blog if  使用SQL片段
    @Test
    public void queryBlogIf2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        //map.put("title","Spring");
        map.put("author","狂神说");
        List<Blog> blogList = blogMapper.queryBlogIf(map);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

   //查询Blog choose
    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
       // map.put("title","Spring");
        map.put("author","狂神说");
        map.put("views",3000);
        List<Blog> blogList = blogMapper.queryBlogChoose(map);

        sqlSession.close();
    }

    //更新Blog
    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","微服务实战");
        map.put("author","狂神说");
        map.put("id","6ee1997bcc27446fb6a948d1f6dca577");

        int i = mapper.updateBlog(map);
        System.out.println("i = "+i);
        sqlSession.close();
    }

    //查询 1,2，3号的Blog
    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        map.put("ids",list);

        List<Blog> blogList = blogMapper.queryBlogForeach(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

}

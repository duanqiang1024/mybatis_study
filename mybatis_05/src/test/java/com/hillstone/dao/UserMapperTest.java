package com.hillstone.dao;


import com.hillstone.pojo.User;
import com.hillstone.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //底层主要应用反射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }


    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();
    }


    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.addUser(new User(8, "Mybatis", "xyz"));
        System.out.println("i="+i);

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.updateUser(new User(8,"MybatisTest","798"));

        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteUser("111");
        System.out.println("i="+i);
        sqlSession.close();
    }
}

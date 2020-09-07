package com.hillstone.dao;

import com.hillstone.pojo.User;
import com.hillstone.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void queryUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user1 = userMapper.queryUserById(1);
        System.out.println(user1);
        sqlSession.close();
        /*int i = userMapper.updateUser(new User(3, "王五", "321"));
        System.out.println("i="+i);*/
        //手动清理缓存
        //sqlSession.clearCache();

        System.out.println("----------------------");
        User user2 = userMapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user1==user2);

        sqlSession2.close();
    }
}

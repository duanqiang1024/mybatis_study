package com.hillstone.dao;


import com.hillstone.pojo.User;
import com.hillstone.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //底层主要应用反射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}

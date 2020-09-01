package com.hillstone.dao;

import com.hillstone.pojo.User;
import com.hillstone.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test  //测试通过ID查询用户
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserListById(1);
        System.out.println(user);

        sqlSession.close();
    }
     //select *  from mybatis.user where id = #{id};
    //类型处理器
    //select id,name ,pwd  from mybatis.user where id = #{id};
}

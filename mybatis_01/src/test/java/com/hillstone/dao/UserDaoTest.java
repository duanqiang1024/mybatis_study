package com.hillstone.dao;

import com.hillstone.pojo.User;
import com.hillstone.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    //测试查询全部用户
    @Test
    public void test() {
        //第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        //关闭 sqlSession
        sqlSession.close();
    }

    @Test  //模糊查询用户
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("哥");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test  //测试通过ID查询用户
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserListById(2);
        System.out.println(user);

        sqlSession.close();
    }

    @Test  //测试通过多个参数查询用户
    public void getUserList2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",1);
        map.put("userName","强哥");
        User user = mapper.getUserListById2(map);
        System.out.println(user);

        sqlSession.close();
    }


    //增删改查需要提交事务
    @Test //测试 ，新增用户
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(new User(5, "王五", "111"));

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",6);
        map.put("userName","Hello");
        map.put("passWord","abc");

        mapper.addUser2(map);

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(5,"TEST","123"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(5);

        sqlSession.commit();
        sqlSession.close();
    }


}

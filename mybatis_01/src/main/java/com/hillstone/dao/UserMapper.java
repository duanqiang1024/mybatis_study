package com.hillstone.dao;

import com.hillstone.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //模糊查询
    List<User> getUserLike(String value);

    //通过ID查询用户
    User getUserListById(int id);

    //通过多个参数查询用户
    User getUserListById2(Map<String,Object> map);

    //insert一个用户
    int addUser(User user);
    //insert一个用户
    int addUser2(Map<String,Object> map);

    //更新一个用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);
}

package com.hillstone.dao;

import com.hillstone.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //通过ID查询用户
    User getUserListById(int id);

    //insert一个用户
    int addUser(User user);

    //更新一个用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);
}

package com.hillstone.dao;

import com.hillstone.pojo.User;

public interface UserMapper {

    //通过ID查询用户
    User getUserListById(int id);

}

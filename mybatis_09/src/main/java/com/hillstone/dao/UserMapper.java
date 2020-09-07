package com.hillstone.dao;


import com.hillstone.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //根据ID查询用户
    User queryUserById(@Param("id") int i );

    //修改用户
    int updateUser(User user);

}

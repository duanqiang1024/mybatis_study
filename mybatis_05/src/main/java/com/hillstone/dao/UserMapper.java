package com.hillstone.dao;

import com.hillstone.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

     //方法存在多个参数，所有的参数前面必须加上 @Param("id")  注解
    @Select("select id ,name , pwd password from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user (id ,name ,pwd ) values (#{id}, #{name}, #{password} )")
    int addUser(User user);

    @Update("update user set name = #{name} ,pwd = #{password} where id = #{id}")
    int updateUser(User user);

}

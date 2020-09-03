package com.hillstone.dao;

import com.hillstone.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查询所有学生信息，以及对应的老师的信息！
    List<Student> getStudent();
}

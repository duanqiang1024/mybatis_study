package com.hillstone.dao;


import com.hillstone.pojo.Teacher;
import com.hillstone.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

@Test
    public void getTeacher(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    Teacher teacher = teacherMapper.getTeacher(1);
    System.out.println(teacher);

    sqlSession.close();
}
}

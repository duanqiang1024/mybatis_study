package com.hillstone.dao;


import com.hillstone.pojo.Student;
import com.hillstone.pojo.Teacher;
import com.hillstone.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void getTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = teacherMapper.getTeacher();

        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }

        sqlSession.close();
    }

    @Test//按照结果查询
    public void getTeacherById(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById(1);
        System.out.println(teacher);
        sqlSession.close();

        /*
        * Teacher{id=1,
        * name='段老师',
        * student=[Student{id=1, name='小明', tid=0},
        *          Student{id=2, name='小红', tid=0},
        *          Student{id=3, name='小张', tid=0},
        *          Student{id=4, name='小李', tid=0},
        *          Student{id=5, name='小王', tid=0}]}
         * */
    }

    @Test
    public void getTeacherById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById2(1);
        System.out.println(teacher);

        sqlSession.close();
    }
}

package com.hhuQd.test;

import com.hhuQd.entity.Teacher;
import com.hhuQd.service.TeacherService;
import com.hhuQd.service.TeacherService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TeacherServiceTest {
    TeacherService teacherService=new TeacherService();
    Teacher teacher=new Teacher("123456","18565423654","张磊","1","258654",2);
    @Test
    public void queryClassTeacher(){
        System.out.println(teacherService.queryClassTeacher("258456"));
    }

    @Test
    public void isLogIn(){
        System.out.println(teacherService.isLogIn("789654","280130"));
    }

    @Test
    public void queryAll() {
        System.out.println(teacherService.queryAll());
    }

    @Test
    public void savaTeacher(){
       teacherService.saveTeacher(teacher);
    }

    @Test
    public void queryTeacherInfo() {
        System.out.println(teacherService.queryTeacherInfo("1122452"));
    }

    @Test
    public void changePwd() {
        System.out.println(teacherService.changePwd("112","222266"));
    }

    @Test
    public void queryTeacherClassInfo() {
        System.out.println(teacherService.queryTeacherClassInfo("1"));
    }
}
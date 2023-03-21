package com.hhuQd.test;

import com.hhuQd.entity.Student;
import com.hhuQd.service.StudentService;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentServiceTest {
    StudentService studentService=new StudentService();
    Student student=new Student("1706030227","张宇",1,"15865482514","789456",2,"我");

    @Test
    public void save() {
        studentService.save(student);
    }

    @Test
    public void studentLogin() {
        studentService.studentLogin("15850609931","258456");
    }
}
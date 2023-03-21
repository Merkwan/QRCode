package com.hhuQd.test;

import com.hhuQd.dao.StudentDao;
import com.hhuQd.entity.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentDaoTest {
    StudentDao studentDao=new StudentDao();
    Student student=new Student("1706030227","张宇",1,"15865482514","789456",2,"我");
    @Test
    public void saveStudent() {
        studentDao.saveStudent(student);
    }

    @Test
    public void queryBySphone() {
        System.out.println(studentDao.queryBySphone(student.getSphone()));
    }

    @Test
    public void queryBySphone2() {
        System.out.println(studentDao.queryBySphone2(student.getSphone()));
    }

    @Test
    public void queryBySNO() {
        System.out.println(studentDao.queryBySNO(student.getSno()));
    }

    @Test
    public void queryStudentCountByClassNo() {
        System.out.println(studentDao.queryStudentCountByClassNo("1"));
    }

    @Test
    public void queryByWeinXinNick() {
        System.out.println(studentDao.queryByWeinXinNick(student.getWeixinnick()));
    }

    @Test
    public void modifyPasswd() {
        System.out.println(studentDao.modifyPasswd(student.getSphone(),"789456"));
    }

    @Test
    public void querySno() {
        System.out.println(studentDao.querySno(student.getCid()));
    }
}
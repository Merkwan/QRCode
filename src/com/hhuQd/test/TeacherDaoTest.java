package com.hhuQd.test;

import com.hhuQd.dao.TeacherDao;
import com.hhuQd.entity.Teacher;
import org.junit.Test;

import javax.jws.Oneway;

import static org.junit.Assert.*;

public class TeacherDaoTest {
    TeacherDao teacherDao=new TeacherDao();
    Teacher teacher=new Teacher("123456","18565423654","张磊","1","258654",2);
    @Test
    public void saveTeacher() {
        teacherDao.saveTeacher(teacher);
    }

    @Test
    public void queryClassTeacher() {
        teacherDao.queryClassTeacher("1706030227");
    }

    @Test
    public void queryTeacherInfo() {
        teacherDao.queryTeacherInfo(teacher.getTid());
    }

    @Test
    public void queryPassword() {
        teacherDao.queryPassword("280130");
    }

    @Test
    public void updatepwd() {
        teacherDao.updatepwd("258659","123456");
    }
}
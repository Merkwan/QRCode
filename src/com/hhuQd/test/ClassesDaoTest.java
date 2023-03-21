package com.hhuQd.test;

import com.hhuQd.dao.ClassesDao;
import com.hhuQd.entity.Classes;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassesDaoTest {
    ClassesDao classesDao=new ClassesDao();
    Classes classes=new Classes(3,"计信院","计算机","90","3");
    @Test
    public void queryAll() {
        System.out.println(classesDao.queryAll());
    }

    @Test
    public void queryByParam() {
        System.out.println(classesDao.queryByParam(classes));
    }

    @Test
    public void save() {
        System.out.println(classes);
    }

    @Test
    public void getYuan() {
        System.out.println(classesDao.getYuan());
    }

    @Test
    public void getZY() {
        System.out.println(classesDao.getZY());
    }

    @Test
    public void getNJ() {
        System.out.println(classesDao.getNJ());
    }

    @Test
    public void getBJ() {
        System.out.println(classesDao.getBJ());
    }

    @Test
    public void getBJAll() {
        System.out.println(classesDao.getBJAll());
    }

    @Test
    public void getClassStuCount() {
        System.out.println(classesDao.getClassStuCount());
    }

    @Test
    public void queryForClassInfo() {
        System.out.println(classesDao.queryForClassInfo(classes.getCid()));
    }
}
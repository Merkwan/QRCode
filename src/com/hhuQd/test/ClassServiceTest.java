package com.hhuQd.test;

import com.hhuQd.entity.Classes;
import com.hhuQd.service.ClassService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassServiceTest {
    ClassService classService=new ClassService();
    Classes classes=new Classes(3,"计信院","计算机","90","3");
    @Test
    public void queryAll() {
        System.out.println(classService.queryAll());
    }

    @Test
    public void saveDictionary() {
        classService.saveDictionary(classes);
    }

    @Test
    public void getYuan() {
        System.out.println(classService.getYuan());
    }

    @Test
    public void getZY() {
        System.out.println(classService.getZY());
    }

    @Test
    public void getNJ() {
        System.out.println(classService.getNJ());
    }

    @Test
    public void getBJ() {
        System.out.println(classService.getBJ());
    }

    @Test
    public void getBJAll() {
        System.out.println(classService.getBJAll());
    }

    @Test
    public void getClassStuCount() {
        System.out.println(classService.getClassStuCount());
    }
}
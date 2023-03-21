package com.hhuQd.dao.inf;

import com.hhuQd.entity.Classes;
import com.hhuQd.entity.Teacher;

import java.util.List;

public interface TeacherDaoInf {
    public Object queryPassword(String tid);
    public Teacher queryTeacherInfo(String id);
    public int updatepwd(String pwd,String id);
    public void saveTeacher(Teacher t);
    public List<Teacher> queryClassTeacher(String tid);
}

package com.hhuQd.service.inf;

import com.hhuQd.entity.Classes;
import com.hhuQd.entity.Teacher;

public interface TeacherServiceInf {
    public int isLogIn(String tid,String tpassword);

    //
     public Teacher queryTeacherInfo(String id);

    public int changePwd(String pwd,String id);

    public Classes queryTeacherClassInfo(String tid);
}

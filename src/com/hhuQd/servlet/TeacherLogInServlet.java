package com.hhuQd.servlet;

import com.hhuQd.entity.Teacher;
import com.hhuQd.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TeacherLogInServlet extends HttpServlet {
    TeacherService teacherService=new TeacherService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid=request.getParameter("id").trim();
        String tpassword=request.getParameter("password").trim();
        int flag=teacherService.isLogIn(tid,tpassword);
        String[] messages={"用户不存在","密码错误"};

        if (flag==2){
            HttpSession session=request.getSession();
            session.setAttribute("id",tid);
            session.setAttribute("password",tpassword);
            Teacher teacher =teacherService.queryTeacherInfo(tid);
            session.setAttribute("teacher",teacher);
            session.setAttribute("cid",teacher.getCid());
            if(teacher!=null)
            {
                session.setAttribute("cid",teacher.getCid());
                session.setAttribute("tname",teacher.getTname());
            }
            request.getRequestDispatcher("/teacher_main.jsp").forward(request,response);
        }
        else{
            request.setAttribute("message",messages[flag]);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

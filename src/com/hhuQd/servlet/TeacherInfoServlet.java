package com.hhuQd.servlet;

import com.hhuQd.entity.Classes;
import com.hhuQd.entity.Teacher;

import com.hhuQd.service.TeacherService;
import com.hhuQd.service.inf.TeacherServiceInf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TeacherInfoServlet extends BaseServlet {
    TeacherService teacherService=new TeacherService();

    protected void teacherinfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object id = req.getSession().getAttribute("id");
        Object password = req.getSession().getAttribute("password");
        TeacherServiceInf teacherService = new TeacherService();
        //int islog = teacherService.isLogIn(id, password);
        if (id == null || password == null) {
            req.setAttribute("message", "请先登录");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            if (teacherService.isLogIn(id.toString(), password.toString()) <= 1) {
                req.setAttribute("message", "请先登录");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            } else {
                //String id = req.getSession().getAttribute("id").toString();
                //String password = req.getSession().getAttribute("password").toString();
                String cid=req.getSession().getAttribute("cid").toString();
                Classes classes = teacherService.queryTeacherClassInfo(cid);
                req.setAttribute("classes", classes);
                req.getRequestDispatcher("/teacher_baseinfo.jsp").forward(req, resp);
            }
        }
    }

    protected void changepwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object id = req.getSession().getAttribute("id");
        Object password = req.getSession().getAttribute("password");
        TeacherServiceInf teacherService = new TeacherService();
        System.out.println(id);
        System.out.println(password);
        if (id == null || password == null) {
            req.setAttribute("message", "请先登录");
            req.getRequestDispatcher("/teacher_login.jsp").forward(req, resp);
        } else {
            if (teacherService.isLogIn(id.toString(), password.toString()) <= 1) {
                req.setAttribute("message", "请先登录");
                req.getRequestDispatcher("/teacher_login.jsp").forward(req, resp);
            } else {
                //String id = req.getSession().getAttribute("id").toString();
                String oldpwd = req.getParameter("oldpwd").trim();
                String newpwd = req.getParameter("newpwd").trim();
                String conewpwd = req.getParameter("conewpwd").trim();
                String[] msgs = {"旧密码错误", "修改成功", "验证密码不一致或密码为空"};
                if (teacherService.isLogIn(id.toString(), oldpwd) == 1) {
                    req.setAttribute("msg", msgs[0]);
                    req.getRequestDispatcher("/change_teacherpwd.jsp").forward(req, resp);
                } else if (newpwd.equals(conewpwd) && newpwd.length()>5) {
                    int flag = teacherService.changePwd(newpwd, id.toString());
                    req.setAttribute("msg", msgs[1]);
                    req.getRequestDispatcher("/changepwd_succ.jsp").forward(req, resp);
                } else {
                    req.setAttribute("msg", msgs[2]);
                    req.getRequestDispatcher("/change_teacherpwd.jsp").forward(req, resp);
                }
            }
        }
    }
}
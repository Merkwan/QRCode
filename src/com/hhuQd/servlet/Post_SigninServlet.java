package com.hhuQd.servlet;

import com.hhuQd.service.QdRecordService;
import com.hhuQd.service.TeacherService;
import com.hhuQd.service.inf.QdRecordServiceInf;
import com.hhuQd.service.inf.TeacherServiceInf;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Post_SigninServlet extends HttpServlet {
    QdRecordServiceInf qdRecordService=new QdRecordService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Object id=request.getSession().getAttribute("id");
            Object password=request.getSession().getAttribute("password");
            TeacherServiceInf teacherService=new TeacherService();
            //int islog=teacherService.isLogIn(id,password);
            if (id==null || password==null){
                request.setAttribute("message","请先登录");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
            else {
                if(teacherService.isLogIn(id.toString(),password.toString())<=1){
                    request.setAttribute("message","请先登录");
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                }
                else {
                    HttpSession session = request.getSession();
                    String end_time = request.getParameter("end_time");
                    session.setAttribute("endtime", end_time);
                    String cid=session.getAttribute("cid").toString();
                    if (qdRecordService.publish_sign(cid,end_time)) {
                        request.getRequestDispatcher("/scan_qr.jsp").forward(request, response);
                    }
                }
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}

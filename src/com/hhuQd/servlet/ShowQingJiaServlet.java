package com.hhuQd.servlet;

import com.hhuQd.entity.Page;
import com.hhuQd.entity.QingJiaRecord;
import com.hhuQd.service.QingJiaRecordService;
import com.hhuQd.service.TeacherService;
import com.hhuQd.service.inf.QingJiaRecordServiceInf;
import com.hhuQd.service.inf.TeacherServiceInf;

import com.hhuQd.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowQingJiaServlet extends BaseServlet {
    QingJiaRecordService qingJiaRecordService=new QingJiaRecordService();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        Object id = req.getSession().getAttribute("id");
        Object password = req.getSession().getAttribute("password");
        String cid=req.getSession().getAttribute("cid").toString();
        TeacherServiceInf teacherService=new TeacherService();
        //int islog = teacherService.isLogIn(id, password);
        if (id==null || password==null){
            req.setAttribute("message","请先登录");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        else {
            if(teacherService.isLogIn(id.toString(),password.toString())<=1){
                req.setAttribute("message","请先登录");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }
            else {
                int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
                int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
                //2 调用BookService.page(pageNo，pageSize)：Page对象
                Page<QingJiaRecord> page = qingJiaRecordService.page(pageNo, pageSize,cid);

                page.setUrl("http://www.txjava.cn:80/qr_check/showqingjiaservlet?action=page");

                //3 保存Page对象到Request域中
                req.setAttribute("page", page);
                //System.out.println("ok1");
                //System.out.println(page.getUrl());
                System.out.println("你好啊啊啊啊");
               // System.out.println(page);
                //4 请求转发到pages/manager/book_manager.jsp页面
                req.getRequestDispatcher("/show_qingjia.jsp").forward(req, resp);
            }
        }
    }
    protected  void isAgree(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int qid=Integer.parseInt(req.getParameter("id").toString());
        //1表示同意，2表示拒绝
        int result=Integer.parseInt(req.getParameter("result").toString());
        String cid=req.getSession().getAttribute("cid").toString();
        if (qingJiaRecordService.isAgreeeQingJia(qid,result)>=0){
            Page<QingJiaRecord> page = qingJiaRecordService.page(pageNo,pageSize,cid);
            page.setUrl("http://www.txjava.cn:80/qr_check/showqingjiaservlet?action=page");
            //3 保存Page对象到Request域中
            req.setAttribute("page",page);

            req.getRequestDispatcher("/show_qingjia.jsp").forward(req,resp);
        }
    }

    protected void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid=req.getSession().getAttribute("cid").toString();
        if(qingJiaRecordService.queryCount(Integer.parseInt(cid))!=0)
            qingJiaRecordService.deleteAll(cid);
        req.getRequestDispatcher("/teacher_main.jsp").forward(req,resp);
    }
}

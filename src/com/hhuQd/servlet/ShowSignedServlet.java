package com.hhuQd.servlet;

import com.hhuQd.entity.Page;
import com.hhuQd.entity.QdRecord;
import com.hhuQd.service.QdRecordService;
import com.hhuQd.service.TeacherService;
import com.hhuQd.service.inf.QdRecordServiceInf;
import com.hhuQd.service.inf.TeacherServiceInf;
import com.hhuQd.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowSignedServlet extends BaseServlet {
    private QdRecordService qdRecordService=new QdRecordService();
    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        Object id=req.getSession().getAttribute("id");
        Object password=req.getSession().getAttribute("password");
        TeacherServiceInf teacherService=new TeacherService();
        if (id==null || password==null){
            req.setAttribute("message","请先登录");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        else {
            if (teacherService.isLogIn(id.toString(),password.toString())<=1){
                req.setAttribute("message","请先登录");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }
            else {
                int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
                int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
                int resultnum = WebUtils.parseInt(req.getParameter("resultnum"), 1);
                String cid=req.getSession().getAttribute("cid").toString();
                //2 调用BookService.page(pageNo，pageSize)：Page对象
                Page<QdRecord> page = qdRecordService.page(pageNo, pageSize, resultnum,cid);
                req.getSession().setAttribute("state",resultnum);
                page.setUrl("http://www.txjava.cn:80/qr_check/showsignedservlet?action=page&resultnum=" + resultnum);
                req.setAttribute("page",page);
                req.getRequestDispatcher("/show_signinfo.jsp").forward(req, resp);
            }
        }
    }

    protected void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result=0;
        result=Integer.parseInt(req.getParameter("result"));
        String cid=req.getSession().getAttribute("cid").toString();
        if(qdRecordService.queryCount(result,Integer.parseInt(cid))!=0)
            qdRecordService.deleteAll(result,cid);
        req.getRequestDispatcher("/teacher_main.jsp").forward(req,resp);
    }
}

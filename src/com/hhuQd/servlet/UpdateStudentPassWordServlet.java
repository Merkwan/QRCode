package com.hhuQd.servlet;

import com.hhuQd.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdateStudentPassWordServlet extends HttpServlet{

        /**
         * Constructor of the object.
         */
        public UpdateStudentPassWordServlet() {
            super();
        }

        /**
         * Destruction of the servlet. <br>
         */
        public void destroy() {
            super.destroy(); // Just puts "destroy" string in log
            // Put your code here
        }

        /**
         * The doGet method of the servlet. <br>
         *
         * This method is called when a form has its tag value method equals to get.
         *
         * @param request
         *            the request send by the client to the server
         * @param response
         *            the response send by the server to the client
         * @throws ServletException
         *             if an error occurred
         * @throws IOException
         *             if an error occurred
         */
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            this.doPost(request, response);
        }

        /**
         * The doPost method of the servlet. <br>
         *
         * This method is called when a form has its tag value method equals to
         * post.
         *
         * @param request
         *            the request send by the client to the server
         * @param response
         *            the response send by the server to the client
         * @throws ServletException
         *             if an error occurred
         * @throws IOException
         *             if an error occurred
         */
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            //System.out.println("Update!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            String stuPhone=String.valueOf(request.getParameter("sphone"));
            String ModifyPasswd=String.valueOf(request.getParameter("spass"));

            //System.out.println("Update!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            StudentDao sdo = new StudentDao();
            sdo.modifyPasswd(stuPhone, ModifyPasswd);
            response.getWriter().println(1);

        }

        /**
         * Initialization of the servlet. <br>
         *
         * @throws ServletException
         *             if an error occurs
         */
        public void init() throws ServletException {
            // Put your code here
        }

    }

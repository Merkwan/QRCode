package com.hhuQd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhuQd.entity.Student;
import com.hhuQd.service.StudentService;

public class AddStudentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddStudentServlet() {
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

		System.out.println("test");

		String sphone = request.getParameter("sphone");
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String weixinnick = request.getParameter("weixinnick");
		String sclass = request.getParameter("sclass");
		String ssex = request.getParameter("ssex");
		String spass = request.getParameter("spass");
		// 在此处省略了服务器端数据的校验
		
		StudentService ss = new StudentService();


		Student s = new Student();
		s.setCid(Integer.parseInt(sclass));// 班级编号
		s.setSname(sname);
		s.setSpassword(spass);
		s.setSphone(sphone);
		s.setSno(sno);
		s.setWeixinnick(weixinnick);

		s.setSsex(Integer.parseInt(ssex));
		try {
			ss.save(s);
			response.getWriter().println(1);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/studentLogin.jsp").forward(request,
					response);
		}

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

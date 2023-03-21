package com.hhuQd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhuQd.entity.Classes;
import com.hhuQd.entity.Teacher;
import com.hhuQd.service.ClassService;
import com.hhuQd.service.TeacherService;

public class AddTeacherServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddTeacherServlet() {
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
		// 取得用户输入的值
		String tname = request.getParameter("tname");
		String tsex = request.getParameter("tsex");
		String tphone = request.getParameter("tphone");
		String tpass = request.getParameter("tpass");
		int cid = Integer.parseInt(request.getParameter("tclass"));
		String tid = request.getParameter("tid");

		System.out.println("===============>"+tname+tsex+" "+tphone+" "+tpass+" "+cid);
		Teacher t = new Teacher();
		t.setTname(tname);
		t.setTpassword(tpass);
		t.setTphone(tphone);
		t.setTsex(tsex);
		t.setCid(cid);
		t.setTid(tid);
		//t.setTsex(Integer.parseInt(tsex));

		TeacherService ts = new TeacherService();
		//ts.saveTeacher(t, tclass);
		ts.saveTeacher(t);
		request.setAttribute("msg", "添加老师成功");
		request.setAttribute("flag", "2");

		// 需要在转向到leader.jsp页面之前，首先把leader.jsp页面中需要查询的数据查询出来
		// 调用 字典业务逻辑类 中查询的方法
		ClassService ds = new ClassService();
		java.util.List<Classes> list = ds.queryAll();
		// 并且将查询的结果存放在某一个范围中
		request.setAttribute("data", list);

		request.getRequestDispatcher("/Manager_Main.jsp").forward(request, response);

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

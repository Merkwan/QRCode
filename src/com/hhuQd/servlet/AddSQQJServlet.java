package com.hhuQd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhuQd.entity.QJrecord;
import com.hhuQd.service.QingJiaRecordService;

/**
 * Servlet implementation class AddSQQJServlet
 */
@WebServlet("/AddSQQJServlet")
public class AddSQQJServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSQQJServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String stuno = request.getParameter("stuno");
		String sname = request.getParameter("sname");
		String sqqj_day = request.getParameter("sqqj_day");
		String sqqj_ls = request.getParameter("sqqj_ls");
		String sqqj_bz = request.getParameter("sqqj_bz");


		System.out.println("=================>"+sqqj_day);
		QJrecord q = new QJrecord();
		q.setQdate2(sqqj_day);
		q.setQreason(sqqj_bz);
		//q.setQshiyou(Integer.parseInt(sqqj_sy));
		q.setStudentno(Integer.parseInt(stuno));
		q.setSname(sname);
		q.setTeacherno(Integer.parseInt(sqqj_ls));
		q.setQresult(0);

		QingJiaRecordService qs = new QingJiaRecordService();
		qs.save(q);

		response.getWriter().println("success");
	}

}

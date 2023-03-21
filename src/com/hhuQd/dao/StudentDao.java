package com.hhuQd.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hhuQd.dao.inf.StudentDaoInf;
import com.hhuQd.entity.Student;
import com.hhuQd.util.DBManager;

public class StudentDao extends BaseDao implements StudentDaoInf {

	private DBManager db = new DBManager();

	public void saveStudent(Student stu) {

		String sql = "insert into student(sno,sname,ssex,sphone,spassword,cid,weixinnick) "
				+ " values( '"
				+ stu.getSno()
				+ "','"
				+ stu.getSname()
				+ "',"
				+ stu.getSsex()
				+ ",'"
				+ stu.getSphone()
				+ "','"
				+ stu.getSpassword()
				+ "',"
				+ stu.getCid()
				+ ",'"
				+ stu.getWeixinnick()+ " ')";

		db.update(sql);

	}

	/**
	 * 通过手机号查找是否存在学生
	 * 
	 * @param sphone
	 * @return
	 */
	public boolean queryBySphone(String sphone) {
		try {
			String sql = "select * from student where sphone= '"+sphone+"'";
			System.out.println(">>>>>>>>>>>>>"+sql);
			ResultSet rs = db.query(sql);

			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConn();
		}
		return true;
	}

	/**
	 * 通过手机号码查找学生信息
	 * 
	 * @param sphone
	 * @return
	 */
	public Student queryBySphone2(String sphone) {
		Student s = null;
		try {
			String sql = "select * from student where sphone= '" + sphone +"'";
			ResultSet rs = db.query(sql);

			while (rs.next()) {
				s = new Student();
				s.setCid(rs.getInt("cid"));
				System.out.println("=============>"+s.getCid());
				s.setSname(rs.getString("sname"));
				System.out.println("=============>"+s.getSname());
				s.setSno(rs.getString("sno"));
				s.setSpassword(rs.getString("spassword"));
				s.setSphone(sphone);
				s.setSsex(rs.getInt("ssex"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConn();
		}
		return s;
	}
	
	
	
	
	/**
	 * 通过学生的编号查找学生的信息
	 * 
	 * @param sno
	 * @return
	 */
	public boolean queryBySNO(String sno) {
		Student s = null;
		try {
			String sql = "select * from student where sno='" + sno + "'";
			System.out.println(">>>>>>>>>>>>>"+sql);
			ResultSet rs = db.query(sql);
			return rs.next();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConn();
		}
		return true;
	}
	
	

	/**
	 * 通过班级编号查找 班级对应的学生个数
	 * 
	 * @return
	 */
	public int queryStudentCountByClassNo(String classno) {
		DBManager db = new DBManager();
		int count = 0;
		try {
			String sql = "select count(sno) countno from student where classno="
					+ classno;
			ResultSet rs = db.query(sql);
			while (rs.next()) {
				count = rs.getInt("countno");
			}
		} catch (SQLException e) {
 			e.printStackTrace();
		} finally {
			db.closeConn();
		}

		return count;
	}
	 /** 通过学生的微信昵称查找学生的信息
	 *
			 * @param weixinnick
	 * @return
			 */
	public boolean queryByWeinXinNick(String weixinnick) {
		try {
			String sql = "select * from student where weixinnick='" + weixinnick + "'";
			System.out.println(">>>>>>>>>>>>>"+sql);
			ResultSet rs = db.query(sql);

			return  rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConn();
		}
		return true;
	}

	public int modifyPasswd(String sphone,String ModifyPasswd){

		String sql = "UPDATE student SET spassword = '"+ModifyPasswd+"' WHERE sphone="+sphone;

		try {
			db.update(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConn();
		return -1;

	}

	@Override
	public List<Student> querySno(int cid) {
		String sql="select `sno`,`sname` from student where cid=?";
		return queryForList(Student.class,sql,cid);
	}
}

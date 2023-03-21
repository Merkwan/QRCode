package com.hhuQd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hhuQd.dao.inf.TeacherDaoInf;
import com.hhuQd.entity.Teacher;
import com.hhuQd.util.DBManager;

public class TeacherDao extends BaseDao implements TeacherDaoInf {
	private DBManager db = new DBManager();

	@Override
	public void saveTeacher(Teacher t) {
		String[] sexs={"女","男"};
		t.setTsex(sexs[Integer.parseInt(t.getTsex())]);
//		String sql = "insert into teacher(tphone,tname,tsex,tpassword,cid) values('"
//				+ t.getTphone()
//				+ "','"
//				+ t.getTname()
//				+ "',"
//				+ t.getTsex()
//				+ ",'"
//				+ t.getTpassword()
//				+ "',"
//				+ t.getCid()
//				+ ")";
//			db.update(sql);
		String sql="insert into teacher(tid,tphone,tname,tsex,tpassword,cid) VALUES(?,?,?,?,?,?)";
		int f=update(sql,t.getTid(),t.getTphone(),t.getTname(),t.getTsex(),t.getTpassword(),t.getCid());
	}

	/**
	 * 得到某一班级的老师信息
	 *
	 * @param sno
	 * @return
	 */
	public List<Teacher> queryClassTeacher(String sno) {
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = "select teacher.tid,teacher.tname from student ,teacher  where student.cid= teacher.cid"
				+" and sno="+
				sno + "";

		try {
			ResultSet rs = db.query(sql);
			while (rs.next()) {
				Teacher t = new Teacher();
				t.setTid(rs.getString("tid"));
				t.setTname(rs.getString("tname"));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Teacher queryTeacherInfo(String id) {
		String sql="select * from teacher where tid=?";
		return quryForOne(Teacher.class,sql,id);
	}

	@Override
	public Object queryPassword(String tid) {
		String sql="select `tpassword` from teacher where tid=?";
		return queryForSingleValue(sql,tid);
	}

	@Override
	public int updatepwd(String pwd,String id) {
		String sql="update teacher set `tpassword`=? where tid=?";
		return update(sql,pwd,id);
	}

//	@Override
//	public Teacher queryTeacherClassInfo(String tid) {
//		String sql="select tname,cid from teacher where tid=?";
//		return quryForOne(Teacher.class,sql,tid);
//	}

}

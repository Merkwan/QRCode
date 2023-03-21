package com.hhuQd.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hhuQd.dao.ClassesDao;
import com.hhuQd.dao.TeacherDao;
import com.hhuQd.dao.inf.TeacherDaoInf;
import com.hhuQd.entity.Classes;
import com.hhuQd.entity.Teacher;
import com.hhuQd.entity.Teacherclass;
import com.hhuQd.service.inf.TeacherServiceInf;
import com.hhuQd.util.DBManager;

/**
 * 教师业务逻辑类
 * 
 * @author Administrator
 * 
 */
public class TeacherService implements TeacherServiceInf {

	TeacherDaoInf teacherDao=new TeacherDao();
	private DBManager db = new DBManager();

	public List<Teacher> queryClassTeacher(String sno) {
		return teacherDao.queryClassTeacher(sno);
	}

	@Override
	public int isLogIn(String tid,String tpassword) {
		Object object=teacherDao.queryPassword(tid);
		if (object==null){
			return 0;
		}
		else if (!(object.toString().equals(tpassword)))
		{
			return 1;
		}
		return 2;
	}
	public List<Teacher> queryAll(){
		List<Teacher> list = new ArrayList<Teacher>();
		try {
			String sql = "select *   from teacher";

			System.out.println("====》》》》》》》" + sql);
			ResultSet rs = db.query(sql);
			while (rs.next()) {
				Teacher q = new Teacher();
				q.setTname(rs.getString("tname"));

				q.setTsex(rs.getString("tsex"));

				q.setCid(rs.getInt("cid"));

				q.setTphone(rs.getString("tphone"));

				q.setTid(rs.getString("tid"));

				list.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	/**
	 * 保存老师信息
	 *
	 * @param t
	 *            一个老师对应多个班级
	 */
	public void saveTeacher(Teacher t) {
		// 首先要保存teacher
		 teacherDao.saveTeacher(t);
		// 保存老师对应的班级
	}

//	@Override
	public Teacher queryTeacherInfo(String id) {
		return teacherDao.queryTeacherInfo(id);
	}

	@Override
	public int changePwd(String pwd, String id) {
		return teacherDao.updatepwd(pwd,id);
	}


	@Override
	public Classes queryTeacherClassInfo(String cid) {
		ClassesDao classesDao=new ClassesDao();
		Classes classes= classesDao.queryForClassInfo(Integer.parseInt(cid));
		return classes;
	}
}

package com.hhuQd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hhuQd.entity.Classes;

import com.hhuQd.entity.Teacherclass;
import com.hhuQd.util.DBManager;
public class TeacherClassDao {
	
	private DBManager db = new DBManager();

	public void save(Teacherclass t) {

		String sql = "insert into teacherclass(teacherid,dictionaryid) values(" + t.getTeacherid()
				+ "," + t.getDictionaryid() + ")";
		db.update(sql);

	}

	/**
	 * 通过老师的编号，获取老师对应的班级信息 
	 * 
	 * @return 
	 */
	public List<Classes> queryByTeacherId(int teacherId) {
		List<Classes> list = new ArrayList<Classes>();
		String sql = "SELECT   d.did , d.dnjname,d.dzyname,d.dbjname from teacher t,dictionary d,teacherclass  tc where t.tid="+teacherId+" and tc.dictionaryid=d.did and tc.teacherid=t.tid";
		ResultSet rs = db.query(sql);
		try {
			while (rs.next()) {

				Classes d = new Classes();
				d.setCgrade(rs.getString("dnjname"));
				d.setCclassno(rs.getString("dbjname"));
				d.setCprofession(rs.getString("dzyname"));
				d.setCid(rs.getInt("did"));
				list.add(d);

			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list;
	}
}

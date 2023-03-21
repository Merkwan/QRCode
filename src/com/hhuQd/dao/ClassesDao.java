package com.hhuQd.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hhuQd.dao.inf.ClassesDaoInf;
import com.hhuQd.entity.Classes;
import com.hhuQd.util.DBManager;

public class ClassesDao extends BaseDao implements ClassesDaoInf {

	private DBManager db = new DBManager();

	/**
	 * 查询所有的字典信息 数据库中一条字典记录 对应一个java类 Dictionary 很多条记录呢 就应该是一个 集合 List 就是一个集合
	 * 
	 * @return
	 */
	public List<Classes> queryAll() {
		// list是一个集合的接口
		// ArrayList是实现了数组动态扩容的一个List接口的实现类
		List<Classes> list = new ArrayList<Classes>();

		String sql = "select * from class order by cid desc ";
		ResultSet rs = db.query(sql);

		try {
			while (rs.next()) {
				// 一条记录对应一个java类对象
				Classes d = new Classes();
				d.setCclassno(rs.getString("cClassNo"));
				d.setCid(rs.getInt("cid"));
				d.setCgrade(rs.getString("cGrade"));
				d.setCdepartment(rs.getString("cDepartment"));
				d.setCprofession(rs.getString("cProfession"));
				list.add(d);// 向集合中添加数据
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConn();

		return list;

	}

	/**
	 * 根据传递的字典数据在数据库中进行查询 如果找到了，则返回true 否则返回 false
	 * 
	 * @param d
	 * @return
	 */
	public boolean queryByParam(Classes d) {
		try {
			String sql = "select * from class where cDepartment='"
					+ d.getCdepartment() + "' AND"
					+ " cProfession='" + d.getCprofession()
					+ "'  " + "AND cGrade='" + d.getCgrade() + "' "
					+ "and  cClassNo='" + d.getCclassno() + "'";

			return db.query(sql).next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeConn();

		return true;

	}

	/**
	 * 保存数据
	 * 
	 * @param d
	 */
	public void save(Classes d) {
		String sql = "insert into class(cDepartment,cProfession,cGrade,cClassNo)"
				+ " values('"
				+ d.getCdepartment()
				+ "','"
				+ d.getCprofession()
				+ "','"
				+ d.getCgrade()
				+ "','"
				+ d.getCclassno() + "')";
		db.update(sql);
	}

	
	
	/**
	 * 得到数据字典中 学院名称不重复的数据
	 * 
	 * @return
	 */
	public List<String> getYuan() {
		List<String> list = new ArrayList<String>();

		String sql = "select DISTINCT cDepartment from class";
		ResultSet rs = db.query(sql);

		try {
			while (rs.next()) {

				list.add(rs.getString("cDepartment"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		db.closeConn();

		return list;
	}


	public List<String> getZY() {
		List<String> list = new ArrayList<String>();

		String sql = "select DISTINCT cProfession from class";
		ResultSet rs = db.query(sql);

		try {
			while (rs.next()) {

				list.add(rs.getString("cProfession"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		db.closeConn();

		return list;
	}

	public List<String> getNJ() {
		List<String> list = new ArrayList<String>();

		String sql = "select DISTINCT cGrade from class";
		ResultSet rs = db.query(sql);

		try {
			while (rs.next()) {

				list.add(rs.getString("cGrade"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		db.closeConn();

		return list;
	}

	public List<String> getBJ() {
		List<String> list = new ArrayList<String>();

		String sql = "select DISTINCT  cClassNo from class";
		ResultSet rs = db.query(sql);

		try {
			while (rs.next()) {

				list.add(rs.getString("cClassNo"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		db.closeConn();

		return list;
	}

	/**
	 * 查询全部的班级
	 * 
	 * @return
	 */
	public List<Classes> getBJAll() {
		// map是键值对集合
		List<Classes> list =  new ArrayList<Classes>();
		String sql = "select * from class";
		ResultSet rs = db.query(sql);

		try {
			while (rs.next()) {
				// 一条记录对应一个java类对象
				Classes d = new Classes();
				d.setCclassno(rs.getString("cClassNo"));
				d.setCgrade(rs.getString("cGrade"));
				d.setCdepartment(rs.getString("cDepartment"));
				d.setCprofession(rs.getString("cProfession"));
				d.setCid(rs.getInt("cid"));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		db.closeConn();

		return list;
	}

	public List<Object[]> getClassStuCount() {

		List<Object[]> list = new ArrayList<Object[]>();

		try {
			String sql = "SELECT CONCAT(class.cprofession,'-',class.cGrade,'级','-',class.cClassNo),count(student.sno) FROM	student,class  where 	student.cid=class.cid group by 	class.cid";
			ResultSet rs = db.query(sql);
			while (rs.next()) {

				Object obj[] = new Object[2];
				obj[0] = rs.getObject(1);
				obj[1] = rs.getObject(2);
				list.add(obj);

			}
		} catch (SQLException e) {
 			e.printStackTrace();
		}

		db.closeConn();

		return list;
	}

	@Override
	public Classes queryForClassInfo(int cid) {
		String sql="select * from class where cid=?";
		return quryForOne(Classes.class,sql,cid);
	}
}

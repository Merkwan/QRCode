package com.hhuQd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.hhuQd.dao.inf.QdRecordDaoInf;
import com.hhuQd.entity.QdRecord;
import com.hhuQd.util.DBManager;

public class QdRecordDao extends BaseDao implements QdRecordDaoInf {

	private DBManager db = new DBManager();


	public void saveRecord(QdRecord q) {
		String sql = " insert into qdrecord(studentno,qdate,qtime,qstarttime) "
				+ "values( " + q.getSno() + ", '" + q.getQdate()
				+ "' , '" + q.getQtime() + "' , '" + q.getLinetime()
				+ "' ) ";

		db.update(sql);

	}

//	/**
//	 * 查询某个班级，某一天，某一堂课的签到学生数量
//	 *
//	 * @param cid
//	 * @param day
//	 *            xxxx-xx-xx
//	 * @param time
//	 *            xx:xx:xx
//	 * @return
//	 */
//	public int queryQDCount(int cid, String day, String time) {
//		DBManager db = new DBManager();
//		int count = 0;
//		try {
//			String sql = "select count(studentno) countsno from "
//					+ " student s,qdrecord qd where s.sno=qd.studentno and "
//					+ " s.cid=" + cid + " and qd.qdate= '" + day + "' "
//					+ "  and qd.qstarttime='" + time + "' ";
//
//			ResultSet rs = db.query(sql);
//			while (rs.next()) {
//				count = rs.getInt("countsno");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			db.closeConn();
//		}
//
//		return count;
//	}

//	/**
//	 * 查询某一个学生编号 在某一天的某一堂课上是否签到了
//	 *
//	 * @param sno
//	 * @param day
//	 * @param startTime
//	 * @return true就是已经签到了
//	 */
//	public boolean getQDData(String sno, String day, String startTime) {
//
//		try {
//			String sql = "select * from qdrecord where studentno=" + sno
//					+ " and qdate='" + day + "' and qstarttime='" + startTime
//					+ "' ";
//			ResultSet rs = db.query(sql);
//			return rs.next();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return true;
//	}

	/**
	 * 查询某一个学生的出勤记录
	 * 
	 * @param stuno
	 * @return
	 */
	public List<QdRecord> queryStudentQDRecord(int stuno) {
		List<QdRecord> list = new ArrayList<QdRecord>();
		try {
			String sql = "select *   from qdrecord where sno=  "
					+ stuno;

			System.out.println("====》》》》》》》" + sql);  
			ResultSet rs = db.query(sql);  
			while (rs.next()) {
				QdRecord q = new QdRecord();
				q.setQdate(rs.getString("qdate"));
				//System.out.println("QJ====》》》》》》》" + q.getQdate());
				Time t1 = rs.getTime("linetime");
				q.setLinetime(t1.toString());
				//System.out.println("====》》》》》》》" + q.getLinetime());
				Time t2 = rs.getTime("qtime");
				q.setQtime(t2.toString());
				//System.out.println("====》》》》》》》" + q.getQtime());
				q.setQdstate(rs.getInt("qdstate"));
				//System.out.println("====》》》》》》》" + q.getQdstate());
				list.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	
	
	
	/**
	 * 查询 某个班级学生的签到记录
	 * 
	 * @param teacherId

	 * @return
	 */
	public List<Object[]> queryDataByteacherId(String teacherId) {
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			String sql = "select qdate, count(qdstate == 1), count(q.sno)   from qdrecord q"
					+ "where q.sno = (select s.sno from student s where cid =" + teacherId + ") group by qdate";

			System.out.println("班级出勤 查询 SQL -->>> " + sql);
			
			ResultSet rs = db.query(sql);
			while (rs.next()) {
				// 一行数据就是一个数组
				Object[] obj = new Object[6];
				obj[0] = rs.getObject("qdate");
				obj[1] = rs.getObject("count(qdstate == 1)");
				obj[2] = rs.getObject("count(q.sno)");
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeConn();
		}
		return list;
	}


	@Override
	public int creat_signinfo(Object[] sno,Object[] sname,Object[] qdate,Object[] qtime,Object[] endtimes) {
		String sql="insert into qdrecord(`sno`,`sname`,`qdate`,`qtime`,`linetime`) values(?,?,?,?,?)";
		return updateManyValues(sql,sno,sname,qdate,qtime,endtimes);
	}


	@Override
	public int changeSign(int flag,String sno,String qdate,String qtime) {
		String sql="update qdrecord set qdstate=?,qtime=? where sno=? and qdate=?";
		return update(sql,flag,qtime,sno,qdate);
	}
	@Override
	public String isSign(String sno,String qdate){
		String sql="select qdstate from qdrecord where sno=? and qdate=?";
		return queryForSingleValue(sql,sno,qdate).toString();
	}
	@Override
	public String selectSno(String weixinnick){
		String sql="select sno from student where weixinnick=?";
		Object object=queryForSingleValue(sql,weixinnick);
		if (object==null)
			return null;
		else return object.toString();
	}
	@Override
	public Object queryForPageTotalCount(int qdstate,int cid) {
		String sql = "select count(qdate) from qdrecord,student where qdrecord.sno=student.sno and qdstate=? and cid=?";
		Object count =queryForSingleValue(sql,qdstate,cid);
		return count;
	}

	@Override
	public List<Object[]> queryForPageItems(int begin, int pageSize, int state,int cid) {
		String sql = "select student.sno ,qdrecord.sname,qdate,qtime,qdstate from qdrecord,student where qdrecord.sno=student.sno and qdstate=? and cid=? order by qdate DESC,qtime DESC limit ?,?";
		//return queryForList(QDRecord.class,sql,resultnum,begin,pageSize);
		List<Object[]> QDRecords=queryForManyLines(sql,state,cid,begin,pageSize);
		//System.out.println(QDRecord);
		return QDRecords;
	}

	@Override
	public int isPost(String qdate){
		String sql="select count(*) from qdrecord where qdate=?";
		return Integer.parseInt(queryForSingleValue(sql,qdate).toString());
	}

	@Override
	public int deleteAll(int state,int cid) {
		String sql="delete qdrecord from qdrecord,student where qdrecord.sno=student.sno and qdstate=? and cid=?";
		return update(sql,state,cid);
	}
}

package com.hhuQd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hhuQd.dao.inf.QingJiaRecordDaoInf;
import com.hhuQd.entity.QJrecord;
import com.hhuQd.util.DBManager;
public class QingJiaRecordDao extends BaseDao implements QingJiaRecordDaoInf {

	
	private DBManager db = new DBManager();

	public void save(QJrecord q) {

		String sql = "insert into qingjiarecord(sno,qreason,sname,qdate,qresult) "
				+ " values("
				+ q.getStudentno()
				+ ",'"
				+ q.getQreason()
				+ "','"
				+ q.getSname()
				+ "','"
				+ q.getQdate2()
				+ "',"+q.getQresult()+" )";
				System.out.println(sql);
		db.update(sql);

	}




	/**
	 * 查询某一个学生的请假记录
	 *
	 * @param stuno
	 * @return
	 */
	public List<QJrecord> queryStudentQJrecord(int stuno) {
		List<QJrecord> list = new ArrayList<QJrecord>();
		try {
			String sql = "select *   from qingjiarecord where sno=  "
					+ stuno;

			System.out.println("====》》》》》》》" + sql);
			ResultSet rs = db.query(sql);
			while (rs.next()) {
				QJrecord q = new QJrecord();
				q.setQdate(rs.getDate("qdate"));
				System.out.println("====》》》》》》》" + q.getQdate());
				String r1 = rs.getString("qreason");
				System.out.println("====》》》》》》》" + r1);
				q.setQreason(r1); // 我们将数据查询的请假原因 转换为了 String
				int re = rs.getInt("qresult");
				System.out.println("====》》》》》》》" + re);
				q.setQresult(re);
				list.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Object[]> queryForPageItems(int begin,int pagesize,int cid) {
		String sql="select qid,qingjiarecord.sno,qingjiarecord.sname,qdate,qresult,qreason from qingjiarecord,student where qingjiarecord.sno=student.sno and cid=? order by qdate DESC,qid limit ?,?";
		return queryForManyLines(sql,cid,begin,pagesize);
	}

	@Override
	public Integer queryForPageTotalCount(int cid) {
		String sql = "select count(qdate) from qingjiarecord,student where qingjiarecord.sno=student.sno and cid=?";
		Number count = (Number) queryForSingleValue(sql,cid);
		return count.intValue();
	}
	@Override
	public int updateQresult(int id,int qresult){
		String sql="update qingjiarecord,student set `qresult`=? where qid=? and qingjiarecord.sno=student.sno";
		return update(sql,qresult,id);
	}

	@Override
	public int deleteAll(int cid) {
		String sql="delete qingjiarecord from qingjiarecord where qingjiaecord.sno=student.sno and cid=?";
		return update(sql,cid);
	}

}

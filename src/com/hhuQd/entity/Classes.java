package com.hhuQd.entity;

import com.hhuQd.util.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Classes {
	private int cid;// ` int(11) NOT NULL AUTO_INCREMENT,
	private String cdepartment;// ` varchar(255) DEFAULT NULL,
	private String cprofession;// ` varchar(255) DEFAULT NULL,
	private String cgrade;// ` varchar(255) DEFAULT NULL,
	private String cclassno;// ` varchar(255) DEFAULT NULL,

	// 快捷键
	// alt+shift+s


	public Classes() {
	}

	public Classes(int cid, String cdepartment, String cprofession, String cgrade, String cclassno) {
		this.cid = cid;
		this.cdepartment = cdepartment;
		this.cprofession = cprofession;
		this.cgrade = cgrade;
		this.cclassno = cclassno;
	}

	public String getChargeTeacher(){
		DBManager db = new DBManager();
		String sql = "select teacher.tname from teacher where teacher.cid = "+this.cid;
		System.out.println(sql);
		ResultSet rs = db.query(sql);
		try {
			if(rs.next())
				return rs.getString("tname");
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  "无负责教师";


	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCdepartment() {
		return cdepartment;
	}

	public void setCdepartment(String cdepartment) {
		this.cdepartment = cdepartment;
	}

	public String getCprofession() {
		return cprofession;
	}

	public void setCprofession(String cprofession) {
		this.cprofession = cprofession;
	}

	public String getCgrade() {
		return cgrade;
	}

	public void setCgrade(String cgrade) {
		this.cgrade = cgrade;
	}

	public String getCclassno() {
		return cclassno;
	}

	public void setCclassno(String cclassno) {
		this.cclassno = cclassno;
	}

	@Override
	public String toString() {
		return "Classes{" +
				"cid=" + cid +
				", cdepartment='" + cdepartment + '\'' +
				", cprofession='" + cprofession + '\'' +
				", cgrade='" + cgrade + '\'' +
				", cclassno='" + cclassno + '\'' +
				'}';
	}
}

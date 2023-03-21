package com.hhuQd.entity;

import java.util.Date;

public class QJrecord {
	private int qid; // ` int(11) NOT NULL,
	private int studentno; //` int(11) DEFAULT NULL,
	private String sname;
	private String qreason; //` varchar(255) DEFAULT NULL,
	private Date qdate; //` datetime DEFAULT NULL,
	private String qdate2; //` datetime DEFAULT NULL,
	private int qresult;//` int(1) DEFAULT NULL,
	
	private int teacherno;
	//private int qshiyou;


	public QJrecord(int qid, int studentno, String sname, String qreason, Date qdate, String qdate2, int qresult, int teacherno) {
		this.qid = qid;
		this.studentno = studentno;
		this.sname = sname;
		this.qreason = qreason;
		this.qdate = qdate;
		this.qdate2 = qdate2;
		this.qresult = qresult;
		this.teacherno = teacherno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getQdate2() {
		return qdate2;
	}
	public void setQdate2(String qdate2) {
		this.qdate2 = qdate2;
	}
	public int getTeacherno() {
		return teacherno;
	}
	public void setTeacherno(int teacherno) {
		this.teacherno = teacherno;
	}
/*	public int getQshiyou() {
		return qshiyou;
	}
	public void setQshiyou(int qshiyou) {
		this.qshiyou = qshiyou;
	}
	*/
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getStudentno() {
		return studentno;
	}
	public void setStudentno(int studentno) {
		this.studentno = studentno;
	}
	public String getQreason() {
		return qreason;
	}
	public void setQreason(String qreason) {
		this.qreason = qreason;
	}
	public Date getQdate() {
		return qdate;
	}
	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}
	public int getQresult() {
		return qresult;
	}
	public void setQresult(int qresult) {
		this.qresult = qresult;
	}
}

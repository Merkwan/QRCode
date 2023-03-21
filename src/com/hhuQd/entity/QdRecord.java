package com.hhuQd.entity;

import java.util.Date;

public class QdRecord {
	//private int qid;// ` int(11) NOT NULL AUTO_INCREMENT,
	private String sno;// ` int(11) DEFAULT NULL,
	private String sname;
//	private Date qdate;// ` datetime DEFAULT NULL,
//	private Date qtime;// ` time DEFAULT NULL,
//	private Date linetime;// ` time DEFAULT NULL,
	private String qdate;// ` datetime DEFAULT NULL,
	private String qtime;// ` time DEFAULT NULL,
	private String linetime;// ` time DEFAULT NULL,
	private int qdstate;
	private int classno;

	public QdRecord() {
	}

	public QdRecord(String sno, String sname, String qdate, String qtime, String linetime, int qdstate,int classno) {
		this.sno = sno;
		this.sname = sname;
		this.qdate = qdate;
		this.qtime = qtime;
		this.linetime = linetime;
		this.qdstate = qdstate;
		this.classno=classno;
	}


	

	//private int qteachermsg;
	
//	public int getQteachermsg() {
//		return qteachermsg;
//	}
//
//	public void setQteachermsg(int qteachermsg) {
//		this.qteachermsg = qteachermsg;
//	}
	
	public int getQdstate() {
		return qdstate;
	}

	public void setQdstate(int qdstate) {
		this.qdstate = qdstate;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

//	public String getQdate1() {
//		return qdate1;
//	}
//
//	public void setQdate1(String qdate1) {
//		this.qdate1 = qdate1;
//	}
//
//	public String getQtime1() {
//		return qtime1;
//	}
//
//	public void setQtime1(String qtime1) {
//		this.qtime1 = qtime1;
//	}
//
//	public String getLinetime1() {
//		return linetime1;
//	}
//
//	public void setLinetime1(String linetime1) {
//		this.linetime1 = linetime1;
//	}
//
//	public int getQid() {
//		return qid;
//	}
//
//	public void setQid(int qid) {
//		this.qid = qid;
//	}
//
//	public int getStudentno() {
//		return studentno;
//	}
//
//	public void setStudentno(int studentno) {
//		this.studentno = studentno;
//	}

	public String getQdate() {
		return qdate;
	}

	public void setQdate(String qdate) {
		this.qdate = qdate;
	}

	public String getQtime() {
		return qtime;
	}

	public void setQtime(String qtime) {
		this.qtime = qtime;
	}

	public String getLinetime() {
		return linetime;
	}

	public void setLinetime(String linetime) {
		this.linetime = linetime;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "QDRecord{" +
				"sno='" + sno + '\'' +
				", sname='" + sname + '\'' +
				", qdate='" + qdate + '\'' +
				", qtime='" + qtime + '\'' +
				", linetime='" + linetime + '\'' +
				", qdstate=" + qdstate +'\'' +
				", classno=" + classno +
				'}';
	}
}

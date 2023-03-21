package com.hhuQd.entity;

public class Student {
	private String sno; //` int(11) NOT NULL COMMENT 'sno��ʾѧ��',
	private String sname; //` varchar(255) NOT NULL,
	private int ssex; //` int(1) DEFAULT NULL,
	private String sphone; //` varchar(11) DEFAULT NULL,
	private String spassword; //` varchar(255) DEFAULT NULL,
	private int cid; //` int(11) DEFAULT NULL,
	private String weixinnick;

	public Student() {
	}

	public Student(String sno, String sname, int ssex, String sphone, String spassword, int cid, String weixinnick) {
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
		this.sphone = sphone;
		this.spassword = spassword;
		this.cid = cid;
		this.weixinnick = weixinnick;
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
	public int getSsex() {
		return ssex;
	}
	public void setSsex(int ssex) {
		this.ssex = ssex;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getWeixinnick(){return weixinnick;}
	public void setWeixinnick(String weixinnick){this.weixinnick = weixinnick;}

	@Override
	public String toString() {
		return "Student{" +
				"sno='" + sno + '\'' +
				", sname='" + sname + '\'' +
				", ssex=" + ssex +
				", sphone='" + sphone + '\'' +
				", spassword='" + spassword + '\'' +
				", cid=" + cid +
				", weixinnick='" + weixinnick + '\'' +
				'}';
	}
}

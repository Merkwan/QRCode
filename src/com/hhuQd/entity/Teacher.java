package com.hhuQd.entity;

public class Teacher {
	private String tid; //` int(11) NOT NULL AUTO_INCREMENT,
	private String tphone;//` varchar(11) NOT NULL,
	private String tname; //` varchar(255) NOT NULL,
	private String tsex; //` int(1) NOT NULL DEFAULT '1',
	private String tpassword; //` varchar(255) NOT NULL,
	private int cid;

	public Teacher() {
	}

	public Teacher(String tid, String tphone, String tname, String tsex, String tpassword,int cid) {
		this.tid = tid;
		this.tphone = tphone;
		this.tname = tname;
		this.tsex = tsex;
		this.tpassword = tpassword;
		this.cid=cid;
	}

	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTphone() {
		return tphone;
	}
	public void setTphone(String tphone) {
		this.tphone = tphone;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}


	@Override
	public String toString() {
		return "Teacher{" +
				"tid=" + tid +
				", tphone='" + tphone + '\'' +
				", tname='" + tname + '\'' +
				", tsex='" + tsex + '\'' +
				", tpassword='" + tpassword + '\'' +
				", cid=" + cid +
				'}';
	}
}

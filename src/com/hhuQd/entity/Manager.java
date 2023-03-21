package com.hhuQd.entity;

/**
 * 实体类的规则是 私有属性 公开方法
 * 
 * @author Administrator
 * 
 */
public class Manager {

	private int mid;
	private String mphone;// ` varchar(11) DEFAULT NULL,
	private String mpass;// ` varchar(255) DEFAULT NULL,
	private String mname;

	public Manager() {
	}

	public Manager(int mid, String mphone, String mpass, String mname) {
		this.mid = mid;
		this.mphone = mphone;
		this.mpass = mpass;
		this.mname = mname;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() { return mname; }

	public void setMname(String mname) { this.mname = mname; }

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	@Override
	public String toString() {
		return "Manager{" +
				"mid=" + mid +
				", mphone='" + mphone + '\'' +
				", mpass='" + mpass + '\'' +
				", mname='" + mname + '\'' +
				'}';
	}
}

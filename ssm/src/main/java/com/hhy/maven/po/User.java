package com.hhy.maven.po;

public class User {
	private Integer userid;
	private String username;
	private String userpwd;
	private String sex;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", sex=" + sex + "]";
	}
	
	
}

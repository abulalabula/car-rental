package com.example.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="usertable")
@NamedQuery(name = "checklogin", query = "FROM UserLogin WHERE email=:email AND password=:password")
public class UserLogin {
	@Id
	@GeneratedValue
	@Column(name="id")
	long userid; // database: BIGINT
	@Basic // Default
	private String email;
	@Column(name="pswd")//Different from db's col name
	private String password;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	

}

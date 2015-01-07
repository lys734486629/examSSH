package com.model.users;

import java.io.Serializable;

public class StuInfo implements Serializable{
	private Long stuid;
	private String stuname;
	private String stupwd;
	private String grade;
	private String major;
	private String classes;
	private String joinyear;
	public StuInfo() { }
	public StuInfo(Long id,String pwd){
		this.stuid=id;
		this.stupwd=pwd;
	}
	public StuInfo(Long id,String name,String pwd,String grade,String major,String classes,String year){
		this.stuid=id;
		this.stuname=name;
		this.stupwd=pwd;
		this.grade=grade;
		this.major=major;
		this.classes=classes;
		this.joinyear=year;
	}
	public Long getStuid(){
		return stuid;
	}
	public void setStuid(Long id){
		this.stuid=id;
	}
	public String getStuname(){
		return stuname;
	}
	public void setStuname(String name){
		this.stuname=name;
	}
	public String getStupwd(){
		return stupwd;
	}
	public void setStupwd(String pwd){
		this.stupwd=pwd;
	}
	public String getGrade(){
		return grade;
	}
	public void setGrade(String grade){
		this.grade=grade;
	}
	public String getMajor(){
		return major;
	}
	public void setMajor(String major){
		this.major=major;
	}
	public String getClasses(){
		return classes;
	}
	public void setClasses(String classes){
		this.classes=classes;
	}
	public String getJoinyear(){
		return joinyear;
	}
	public void setJoinyear(String year){
		this.joinyear=year;
	}
	
}

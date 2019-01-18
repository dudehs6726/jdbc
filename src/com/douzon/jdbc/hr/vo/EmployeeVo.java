package com.douzon.jdbc.hr.vo;

public class EmployeeVo {

	private long no;
	private String name;
	private String hire_date;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	
	@Override
	public String toString() {
		return "사원번호: " + no + " , 이름: " + name + ", 입사일: " + hire_date;
	}
	
	
}

package com.douzon.jdbc.hr.test;

import java.util.List;

import com.douzon.jdbc.hr.dao.EmployeeDao;
import com.douzon.jdbc.hr.vo.EmployeeVo;

public class EmployeeDaoTest {

	public static void main(String[] args) {

		String str = "fa";
		getListTest(str);
	}
	
	public static void getListTest(String name) {
		List<EmployeeVo> list = new EmployeeDao().getList(name);
		
		for(EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}

}

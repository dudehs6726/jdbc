package com.douzon.jdbc.hr;

import java.util.List;
import java.util.Scanner;

import com.douzon.jdbc.hr.dao.EmployeeDao;
import com.douzon.jdbc.hr.vo.EmployeeVo;

public class HRMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("사원정보를 원하는 사원의 이름을 입력하세요.:");
		String no = scanner.nextLine();
		scanner.close();
		
		searchName(no);

	}
	
	private static void searchName(String name) {
		List<EmployeeVo> list = new EmployeeDao().getList(name);
		
		for(EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}

}

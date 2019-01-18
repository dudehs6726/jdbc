package com.douzon.jdbc.bookshop.test;

import java.util.List;

import com.douzon.jdbc.bookshop.dao.AuthorDao;
import com.douzon.jdbc.bookshop.vo.AuthorVo;

public class AutherDaoTest {

	public static void main(String[] args) {
		//insertTest("스페파니메이어");
		//insertTest("조정래");
//		insertTest("천상병");
//		insertTest("김동인");
//		insertTest("김난도");
//		insertTest("원수연");
		getListTest();
		
	}
	
	public static void insertTest(String name) {
		AuthorVo vo = new AuthorVo();
		vo.setName(name);
		vo.setBio("");
		new AuthorDao().insert(vo);
	}
	
	public static void getListTest() {
		List<AuthorVo> list = new AuthorDao().getList();
		for(AuthorVo vo : list) {
			System.out.println(vo);
		}
	}
}

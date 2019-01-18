package com.douzon.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertTest {

	public static void main(String[] args) {
		
		boolean result = insert("마음이3", "또치", "dog", "f", "2018-12-10");
		System.out.println(result);
	}
	
	public static boolean insert(
			String name, 
			String owner, 
			String speccies, 
			String gender, 
			String birth) {
		
		Connection conn = null;
		Statement stmt = null;
		boolean bl = false;
		try {
			// 1.JDBC Driver(MySQL) 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2.연결하기(Connection 객체 얻어오기)
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3.Statement 객체를 생성
			stmt = conn.createStatement();
			
			// 4.SQL문 실행
			String sql = "insert into pet VALUES"
					+ " ('" + name +"', '"+ 
							owner +"', '" + 
							speccies + "', '"+ 
							gender +"', '"+ 
							birth +"', null)";
			int count =  stmt.executeUpdate(sql);
			bl = count == 1;
		
			//System.out.println("연결성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bl;
	}

}

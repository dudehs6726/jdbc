package com.douzon.jdbc.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.jdbc.hr.vo.EmployeeVo;

public class EmployeeDao {

	public List<EmployeeVo> getList(String name) {
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			
			// 4.SQL문 실행
			String sql = "select a.emp_no, " + 
					"     		concat(a.first_name, ' ', a.last_name) as name, " + 
					"            a.hire_date " + 
					"       from employees a " + 
					"      where concat(a.first_name, ' ', a.last_name) LIKE concat('%', '" + name + "', '%')";
			
			rs =  stmt.executeQuery(sql);
			
			
			// 5. 결과 가져오기
			while(rs.next()) {
				long no = rs.getLong(1);
				String fullName = rs.getString(2);
				String hireDate = rs.getString(3);
				
				EmployeeVo vo = new EmployeeVo();
				vo.setNo(no);
				vo.setName(fullName);
				vo.setHire_date(hireDate);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
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
		
		return list;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			// 1.JDBC Driver(MySQL) 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2.연결하기(Connection 객체 얻어오기)
			String url = "jdbc:mysql://localhost:3306/employees";
			conn = DriverManager.getConnection(url, "emp", "1234");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		}
		
		return conn;
	}
}

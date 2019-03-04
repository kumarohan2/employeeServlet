package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeService {
	public Employee getEmployeeDetails(int empid) {
		Connection conn = null;
		PreparedStatement sm = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			System.out.println("connected to oracle");
			String sql = "Select" +" first_name,last_name,"+"email,phone_number,hire_date,"+"salary from employees where employee_id=? ";
			sm = conn.prepareStatement(sql);
			sm.setInt(1, empid);
			rs = sm.executeQuery();
			if (rs.next()) {
				Employee emp=new Employee();
				emp.setEmployeeid(empid);
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setPhoneNumber(rs.getString(4));
				emp.setHiredate(rs.getString(5));
				emp.setSalary(rs.getDouble(6));
				return emp;

			}
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

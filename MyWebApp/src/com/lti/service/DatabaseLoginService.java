package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseLoginService {

	public boolean isValidUser(String username, String password) {
		Connection conn = null;
		PreparedStatement sm = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			System.out.println("connected to oracle");
			String sql = "Select count(1) from " + "TBL_USER  where " + "username=? and password =? "	+ "and active='y' ";
			sm = conn.prepareStatement(sql);
			sm.setString(1, username);
			sm.setString(2, password);
			rs = sm.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count == 1)
					return true;
				return false;
			} else
				return false;

		} catch (Exception e) {// bad,should catch individual exception(s)
			e.printStackTrace();// should throw user defined exception instead
			return false;
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				sm.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
			
		}
	}
	public String getFullName(String username) {
		//String url="jdbc:oracle:thin:@localhost:1521:XE";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		String fullname="Test";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			System.out.println("connected to oracle");
			String sql1 = ("Select fullname  from TBL_USER  where  username=? ");
			stmt = con.prepareStatement(sql1);
			stmt.setString(1, username);
			res = stmt.executeQuery();
			if (res.next()) {
		fullname=res.getString("fullname");
	}
			return fullname;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return "anonymous";
		}finally {
			try {res.close(); } catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			try{con.close();} catch(Exception e) {}
		}
		}
}

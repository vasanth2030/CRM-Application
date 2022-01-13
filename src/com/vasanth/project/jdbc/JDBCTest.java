package com.vasanth.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {

	public static void main(String[] args) {
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String uname="hbstudent";
		String pass="hbstudent";
		try {
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url,uname,pass);
			
			System.out.println("SUCCESS!");
			
			
			
			
		} catch (Exception e) {
		System.out.println(e);
		}

	}

}

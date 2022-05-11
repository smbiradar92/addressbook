package com.addressbook.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Constants {

	public static final String JDBC_path = "jdbc:mysql://localhost:3306/addressbook";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";

	public final String FETCH_CONTACTS = "select * from addressbook";

	public void connectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connect = null;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
			System.out.println("Connection Established");
		} catch (Exception e) {
			System.out.println("Connection not established");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Constants constant = new Constants();
		constant.connectionDB();
	}
	
	
}

package com.addressbook.mysql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Constants {

	public static final String JDBC_path = "jdbc:mysql://localhost:3306/addressbook";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";

	public final String FETCH_CONTACTS = "select * from addressbook";

	public void connectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(
					"Driver loaded successfully!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found" + e);
			e.printStackTrace();
		}

		Connection connect = null;
		try {
//			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
			connect = DriverManager.getConnection(JDBC_path,
					USERNAME, PASSWORD);

			System.out.println(
					"Connection established successfully to "
							+ JDBC_path);
		} catch (Exception e) {
			System.out
					.println("Connection not established");
			e.printStackTrace();
		}

	}

	private void listDrivers() {
		Enumeration<Driver> driverList = DriverManager
				.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = driverList.nextElement();
			System.out.println(
					driverClass.getClass().getName());
		}
	}

	public static void main(String[] args) {
		Constants constant = new Constants();
		constant.connectionDB();
		constant.listDrivers();

	}

}

package com.util;

import java.sql.*;

public class DatabaseConnection {
	
	public static String name = "com.mysql.jdbc.Driver";
	public static String un = "root";
	public static String pw = "southampton6835";
	public static String url = "jdbc:mysql://localhost:3310/ajax";
	public static Connection con;
	public static ResultSet rs;
	public static PreparedStatement ps;

	public static Connection getConnection() {
		try {
			Class.forName(name);
			con = (Connection) DriverManager.getConnection(url, un, pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static ResultSet executeQuery(String sql) {
		con = getConnection();
		System.out.println("inside executeQuery ");
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("END executeQuery ");
		return rs;

	}
	public static int executeUpdate(String sql) {
		con=getConnection();
		int i = 0;
		try {
			ps = con.prepareStatement(sql);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}
}

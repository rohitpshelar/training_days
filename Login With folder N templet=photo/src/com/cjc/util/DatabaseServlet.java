package com.cjc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseServlet  {

	

		private static Connection con=null;
		private static ResultSet rs=null;
		private static String Driver="com.mysql.jdbc.Driver";
		private static String URL="jdbc:mysql://localhost:3310/login";
		private static String UserNAme="root";
		private static String Pass="southampton6835";
		private static PreparedStatement pst=null;
		
		public static Connection GetConnection()
		{
			try {
				
				Class.forName(Driver);
				System.out.println("Driver Loaded..");

				con=DriverManager.getConnection(URL,UserNAme,Pass);
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return con;
		}
		
		public static int ExecuteUpdate(String qry)
		{
			int n=0;
			try {
				con=GetConnection();
				
				pst=con.prepareStatement(qry);
		
				n=pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return n;
		}
		
		public static ResultSet ExecuteQuery(String qry)
		{
			
			try {

				con=GetConnection();
				System.out.println("Connection Established..");
				
				pst=con.prepareStatement(qry);
				System.out.println(qry);
				rs=pst.executeQuery();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			return rs;
		}
	
	
}

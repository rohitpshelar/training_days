package com.pro;

import java.sql.Connection;
import java.sql.DriverManager;





public class ConnectionProject {
	static Connection con =null;
public static  Connection connectionProjectMethod() {
	try{
	Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
	
	
	
	}catch(Exception e){
		
		
	}
	return con;
}
	
	
}

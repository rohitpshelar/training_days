package com.pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.mysql.jdbc.Statement;



public class Corse {


	
	private String id;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	static Corse c;
	static	Faculty cou = new Faculty();
	Integer noOfLine;
	String is;
static	int count;

static	ArrayList<Corse> array = new ArrayList<Corse>();

public Scanner s;



	public ArrayList<Corse> getArray() {
		return array;
	}
static	Connection con;
static String sa;
	public void insert() {
	
		try{
		System.out.println("How many No. of course you want to enter:");
		s = new Scanner(System.in);

		try {
			noOfLine = s.nextInt();
		} catch (Exception e) {
			System.out.println("**NOTE:Enter PROPER FIELD (in first try)*");
		} finally {

			if (noOfLine instanceof Integer) {
				for (int i = 1; i <= noOfLine; i++) {
					System.out.println("Your Course ID is:");
					try {
						
						
						ConnectionProject connectionProject=new ConnectionProject();
						 con=ConnectionProject.connectionProjectMethod();
						String sql="SELECT * FROM `project`.`course` LIMIT 0, 30; ";
						PreparedStatement ps=con.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						
						count=0;
						
						is = "c0"+count++;
					
						while(rs.next()){
						
						if(is.equals(rs.getString(1))){
						
							is = "c0"+count;
						}
						is = "c0"+count++;
						}
						
						count=0;
						
						System.out.println(is);
					} catch (Exception e) {
						System.out.println("**NOTE:Enter PROPER FIELD (in Second try)*");
					} finally {
						System.out.println("Enter Course name for "+is+":");
						sa = s.next();
						Corse c = new Corse();
						c.setId(is);
						c.setName(sa);
						
						ConnectionProject connectionProject=new ConnectionProject();
						 con=ConnectionProject.connectionProjectMethod();
						String sql="INSERT INTO `project`.`course` (`cid`, `cname`) VALUES (?, ?);";
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, is);
						ps.setString(2, sa);
						ps.executeUpdate();
						con.close();
						array.add(c);
						
						
						System.out.println("*SAVED*");
					}
				}
			} else {

				c.insert();
			}
		}}catch(Exception e){
			
			System.out.println("in catch");
		}
	}

	public void display() {
	
		System.out.println("----------********COURSE   AVAILABLE   ARE*******--------------");
		System.out.println("");
		System.out.println("ID    NAME");

		try{
		ConnectionProject connectionProject=new ConnectionProject();
		 con=ConnectionProject.connectionProjectMethod();
		String sql="SELECT * FROM `project`.`course` LIMIT 0, 30; ";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getString(1)+"          "+rs.getString(2));
			
		}
		}catch(Exception e)
		{
			
		}

		System.out.println("--------------------------------------------------------------------------");
	}
}

package com.pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Batch extends Faculty {
	
	 static Batch b = new Batch();
	Corse cc = new Corse();

	ArrayList<Corse> array = (ArrayList<Corse>) cc.getArray();

	Faculty ff = new Faculty();
	ArrayList<Faculty> array1 = (ArrayList<Faculty>) ff.getArray1();

static	ArrayList<Batch> array2 = new ArrayList<Batch>();

	public ArrayList<Batch> getArray2() {
	return array2;
}
	private String bid;
	private String bname;
	private Faculty faculty;

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}
	
String bis;
static int count;
static String is;
Faculty f = new Faculty();
private Scanner s;
static Connection con2;

	public void insertB() {

		int noOfLineb = 0;

		s = new Scanner(System.in);

			try {
			

					System.out.println("How many No. of Batch you want to enter:");
					noOfLineb = s.nextInt();
		
				for (int i = 1; i <= noOfLineb; i++) {
				
						System.out.println("Your Batch ID is:");

						ConnectionProject connectionProject=new ConnectionProject();
						 con=ConnectionProject.connectionProjectMethod();
						String sql="SELECT * FROM `project`.`batch` LIMIT 0, 30; ";
						PreparedStatement ps=con.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						
						count = 0;
						is = "b0" + count;
						while (rs.next()) {
							if (is.equals(rs.getString(1))) {
								is = "b0" + count;
							}
							is = "b0" + count++;
						}
						is = "b0" + count;

						System.out.println(is);
						count = 0;
					System.out.println("Enter Batch name for"+is+":");

					String sa = s.next();
					ff.displayf();
					System.out.println("Allocate  Faculty ID  to " + sa + "  from above  :");
					bis = s.next();
					String bbis=bis;
					
					try {
						ConnectionProject connectionProjects = new ConnectionProject();
						con3 = ConnectionProject.connectionProjectMethod();
						String sqls = "SELECT * FROM `faculty` INNER JOIN `course` ON `faculty`.`cid`=`course`.`cid` LIMIT 0, 1000;";
						PreparedStatement pss = con3.prepareStatement(sqls);
						ResultSet rss = pss.executeQuery();
					
					Batch b = new Batch();
					b.setBid(is);// 11
					b.setBname(sa);// 22
					
					while(rss.next()){
						Faculty f = new Faculty();
						f.setFid(rss.getString(1));
						f.setFname(rss.getString(2));
						Corse c = new Corse();
						c.setId(rss.getString(3));
						c.setName(rss.getString(5));
						f.setCorse(c);
						array1.add(f);
					
						
					}
					
					Iterator<Faculty> iter = array1.iterator();
					while (iter.hasNext()) {
						Faculty ff = iter.next();

								if (ff.getFid().equals(bis)) {


									b.setFaculty(ff);// 33
									
									ConnectionProject connectionProject2=new ConnectionProject();
									 con2=ConnectionProject.connectionProjectMethod();
									 String sql2="INSERT INTO `project`.`batch` (`bid`, `bname`, `fid`) VALUES (?,?,?);";
									PreparedStatement ps2=con2.prepareStatement(sql2);
									ps2.setString(1, is);
									ps2.setString(2, sa);
									ps2.setString(3, ff.getFid());
									ps2.executeUpdate();
									con2.close();
									
									array2.add(b);

								}

							
							}
				
					
					System.out.println("*@" + sa + " entry SAVED@*");
						} catch (Exception e) {
							System.out.println("in catch");
							e.printStackTrace();
						}
					
				
				}} catch (Exception e) {
				s = new Scanner(System.in);
				
			}
		
	}

	public void displayB() {
		System.out.println("-----------********DETAILED Batch   DISPLAY ********---------------");
		System.out.println("");
		System.out.println("Batch ID     Batch Name    Faculty Name    Course Name ");

		try {
			ConnectionProject connectionProjects = new ConnectionProject();
			con3 = ConnectionProject.connectionProjectMethod();
			System.out.println("");

			String sqls = "SELECT * FROM `batch` JOIN `faculty` ON `batch`.`fid`=`faculty`.`fid` JOIN `course` ON `faculty`.`cid`=`course`.`cid` ;";
			PreparedStatement pss = con3.prepareStatement(sqls);
			ResultSet rss = pss.executeQuery();
			while (rss.next()) {

				System.out.println(rss.getString(1) + "                      " + rss.getString(2)
						+ "                       " + rss.getString(5) + "                        " + rss.getString(8));
				System.out.println("----------------------------------------------------------------------");

			}
	
		}catch (Exception e) {
				System.out.println("in catch");
				e.printStackTrace();
		}}
		}
		
	


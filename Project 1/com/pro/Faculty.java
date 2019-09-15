package com.pro;

import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Faculty extends Corse {
	Corse cc = new Corse();

	ArrayList<Corse> array = (ArrayList<Corse>) cc.getArray();

	static ArrayList<Faculty> array1 = new ArrayList<Faculty>();

	public ArrayList<Faculty> getArray1() {
		return array1;
	}

	public ArrayList<Corse> getArray() {
		return array;
	}

	Scanner s = new Scanner(System.in);

	static Faculty cou = new Faculty();

	static String fis;

	private String fid;

	private String fname;

	private Corse corse;

	public Corse getCorse() {
		return corse;
	}

	public void setCorse(Corse corse) {
		this.corse = corse;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	Corse c = new Corse();

	private Scanner s2;
	static int count;
	static int noOfLine;
	static Connection con2;
	static String is;

	public void insertf() {

		try {

			s2 = new Scanner(System.in);
			boolean flag = true;
			while (flag) {
				flag = false;
				try {

					System.out.println("How many No. of Faculty you want to enter:");
					noOfLine = s2.nextInt();

					for (int i = 1; i <= noOfLine; i++) {

						System.out.println("Your Faculty ID is:");

						ConnectionProject connectionProject = new ConnectionProject();
						con = ConnectionProject.connectionProjectMethod();
						String sql = "SELECT * FROM `project`.`faculty` LIMIT 0, 30; ";
						PreparedStatement ps = con.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();

						count = 0;
						is = "f0" + count;
						while (rs.next()) {
							if (is.equals(rs.getString(1))) {
								is = "f0" + count;
							}
							is = "f0" + count++;
						}

						is = "f0" + count;

						System.out.println(is);
						count = 0;
						System.out.println("Enter Faculty name for " + is + ":");

						String sa = s2.next();
						c.display();
						System.out.println("Allocate  Courde ID  to " + sa + "  from above  :");
						fis = s2.next();
						String ffis = fis;
						Faculty fi = new Faculty();
						fi.setFid(is);// 1
						fi.setFname(sa);// 2

						ConnectionProject connectionProject3 = new ConnectionProject();
						con = ConnectionProject.connectionProjectMethod();
						String sql3 = "SELECT * FROM `project`.`course` LIMIT 0, 30; ";
						PreparedStatement ps3 = con.prepareStatement(sql3);
						ResultSet rs3 = ps3.executeQuery();

						while (rs3.next()) {
							Corse c = new Corse();
							c.setId(rs3.getString(1));
							c.setName(rs3.getString(2));
							array.add(c);
						}

						Iterator<Corse> itr = array.iterator();// =====
						while (itr.hasNext()) {
							Corse cc = itr.next();
							if (cc.getId().equals(fis)) {
								fi.setCorse(cc);// 3

								ConnectionProject connectionProject2 = new ConnectionProject();
								con2 = ConnectionProject.connectionProjectMethod();
								String sql2 = "INSERT INTO `project`.`faculty` (`fid`, `fname`, `cid`) VALUES (?, ?,?);";
								PreparedStatement ps2 = con2.prepareStatement(sql2);
								ps2.setString(1, is);
								ps2.setString(2, sa);
								ps2.setString(3, cc.getId());
								ps2.executeUpdate();
								con2.close();

								array1.add(fi);
							}

						}

						System.out.println(array1);
						System.out.println("*@" + sa + " entry SAVED@*");

					}
				} catch (Exception e) {
					System.out.println("in ff catch");
					s2 = new Scanner(System.in);
					// flag = false;
				}
			}
		} catch (Exception e) {
			System.out.println("in F catch");
		}
	}

	Connection con3;

	public void displayf() {
		System.out.println("-----------********DETAILED  Faculty  DISPLAY ********---------------");
		System.out.println("");
		System.out.println("courseID    courseNAME  FacultyID    FacultyNAME ");
		try {
			ConnectionProject connectionProjects = new ConnectionProject();
			con3 = ConnectionProject.connectionProjectMethod();
			String sqls = "SELECT * FROM `faculty` INNER JOIN `course` ON `faculty`.`cid`=`course`.`cid` LIMIT 0, 1000;";
			PreparedStatement pss = con3.prepareStatement(sqls);
			ResultSet rss = pss.executeQuery();

			while (rss.next()) {

				System.out.println(rss.getString(3) + "                      " + rss.getString(5)
						+ "                       " + rss.getString(1) + "                        " + rss.getString(2));
				System.out.println("----------------------------------------------------------------------");

			}
		} catch (Exception e) {
			System.out.println("in catch");
			e.printStackTrace();
		}
	}
}

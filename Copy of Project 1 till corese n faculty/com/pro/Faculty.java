package com.pro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Faculty {

	ArrayList<Corse> array = new ArrayList<Corse>();

	ArrayList<Faculty> array1 = new ArrayList<Faculty>();

	Scanner s = new Scanner(System.in);

	static Faculty cou = new Faculty();

	Integer fis;

	public static void main(String[] args) {
		Faculty f = new Faculty();
		f.case1();
	}

	private void case1() {
		System.out.println("Enter 1 to Enter Software OR 0 to EXIT");
		int a = s.nextInt();
		Faculty cou1 = new Faculty();
		switch (a) {
		case 1:
			cou1.case2();
			break;

		case 2:
			System.out.println("THANK YOU");
			System.exit(0);
			break;
		}
	}

	private void case2() {
		System.out.println("");
		System.out.println("******OPTIONS*****");
		System.out.println("Press 1.===== Insert Course");
		System.out.println("Press 2.===== Display Course");
		System.out.println("Press 3.===== Insert Faculty");
		System.out.println("Press 4.===== Display Faculty");
		System.out.println("Press 5.===== EXIT OPTION");

		int b = s.nextInt();
		switch (b) {
		case 1:
			try {
				cou.insert();
				cou.display();
				cou.case2();
				break;

			} catch (Exception e) {
				System.out.println("**NOTE:Enter PROPER  FIELD (1 CHANCE)*");
				try {
					cou.insert();
				} catch (Exception e1) {
					System.out.println("**NOTE:Enter PROPER FIELD (2 CHANCE)*");
					cou.insert();
				}
			}

		case 2:
			cou.display();
			cou.case2();
			break;

		case 3:
			cou.insertf();
			cou.displayf();
			cou.case2();
			break;

		case 4:
			cou.displayf();
			cou.case2();
			break;

		case 5:
			cou.case1();
			break;
		}
	}

	private int fid;

	private String fname;

	private Corse corse;

	public Corse getCorse() {
		return corse;
	}

	public void setCorse(Corse corse) {
		this.corse = corse;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	Integer noOfLine;

	Integer is;

	public void insert() {

		System.out.println("How many No. of course you want to enter:");
		Scanner s = new Scanner(System.in);

		try {
			noOfLine = s.nextInt();
		} catch (Exception e) {
			System.out.println("**NOTE:Enter PROPER FIELD (in first try)*");
		} finally {

			if (noOfLine instanceof Integer) {
				for (int i = 1; i <= noOfLine; i++) {
					System.out.println("Enter " + i + "st Course ID:");
					try {
						is = s.nextInt();
					} catch (Exception e) {
						System.out
								.println("**NOTE:Enter PROPER FIELD (in Second try)*");
					} finally {
						System.out.println("Enter " + i + "st Course name:");
						String sa = s.next();
						Corse c = new Corse();
						c.setId(is);
						c.setName(sa);
						array.add(c);
						System.out.println("*SAVED*");
					}
				}
			} else {

				cou.insert();
			}
		}
	}

	public void display() {
		int counter = 0;
		System.out
				.println("----------********COURSE   AVAILABLE   ARE*******--------------");
		System.out.println("");
		System.out.println("ID    NAME");

		Iterator<Corse> itr = array.iterator();
		while (itr.hasNext()) {
			counter++;
			Corse name = itr.next();
			System.out.println(name.getId() + "    --   " + name.getName());
		}
		System.out
				.println("--------------------------------------------------------------------------");
	}

	public void insertf() {

		int noOfLine=0;
		Integer is =0;
			Scanner s = new Scanner(System.in);
			boolean flag=true;
			while(flag)
			{
				flag=false;
				try{
					if(noOfLine==0){
				
			System.out.println("How many No. of Faculty you want to enter:");
			noOfLine = s.nextInt();
					}
			for (int i = 1; i <= noOfLine; i++) {
				if(is==0){
				System.out.println("Enter " + i + "st Faculty ID:");
				
				 is = s.nextInt();
				}
				System.out.println("Enter " + i + "st Faculty name:");

				String sa = s.next();
				cou.display();
				System.out.println("Allocate  Courde ID  to " + sa					+ "  from above  :");
				fis = s.nextInt();
				Faculty fi = new Faculty();
				fi.setFid(is);// 1
				fi.setFname(sa);// 2
				Iterator<Corse> itr = array.iterator();// =====
				while (itr.hasNext()) {
					Corse cc = itr.next();
					if (cc.getId() == fis) {
						cc.getId();
						cc.getName();
						fi.setCorse(cc);// 3
					}
				}
				array1.add(fi);
				System.out.println("*@" + sa + " entry SAVED@*");
			
		}}catch(Exception e){
			s=new Scanner(System.in);
			flag=true;
		} }
	}

	public void displayf() {
		System.out
				.println("-----------********DETAILED   DISPLAY ********---------------");
		System.out.println("");
		System.out.println("courseID    courseNAME  FacultyID    FacultyNAME ");

		Iterator<Faculty> itrf = array1.iterator();
		while (itrf.hasNext()) {
			Faculty ff = itrf.next();
			Iterator<Corse> itr = array.iterator();
			while (itr.hasNext()) {
				Corse cc = itr.next();
				if (cc.getId() == fis) {
					System.out.println(ff.corse.getId()
							+ "                      " + ff.corse.getName()
							+ "                       " + ff.getFid()
							+ "                        " + ff.getFname());
					System.out.println("----------------------------------------------------------------------");
				}
			}
		}
	}
}

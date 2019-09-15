package com.pro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Student extends Batch {
	Corse cc = new Corse();
	ArrayList<Corse> array = (ArrayList<Corse>) cc.getArray();

	Faculty ff = new Faculty();
	ArrayList<Faculty> array1 = (ArrayList<Faculty>) ff.getArray1();

	Batch bb = new Batch();
	ArrayList<Batch> array2 = (ArrayList<Batch>) bb.getArray2();

	static ArrayList<Student> array3 = new ArrayList<Student>();

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	private String sid;
	private String sname;
	private Batch batch;

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public void case1() {
		s2 = new Scanner(System.in);
		System.out.println("Enter 1 to Enter Software OR 0 to EXIT");
		int a = s2.nextInt();
		Student cou1 = new Student();
		switch (a) {
		case 1:
			cou1.case2();
			break;

		case 0:
			System.out.println("THANK YOU");
			System.exit(0);
			break;
		}
	}

	Corse c = new Corse();
	Faculty f = new Faculty();
	Batch b = new Batch();

	static Student cou = new Student();

	private Scanner s;

	private Scanner s2;

	public void case2() {
		s = new Scanner(System.in);
		System.out.println("");
		System.out.println("******OPTIONS*****");
		System.out.println("Press 1.===== Insert Course");
		System.out.println("Press 2.===== Display Course");
		System.out.println("Press 3.===== Insert Faculty");
		System.out.println("Press 4.===== Display Faculty");
		System.out.println("Press 5.===== Insert Batch");
		System.out.println("Press 6.===== Display Batch");
		System.out.println("Press 7.===== Insert Student");
		System.out.println("Press 8.===== Display Student");
		System.out.println("Press 9.===== SEARCH");
		System.out.println("Press 10===== EXIT OPTION");

		int ib = s.nextInt();
		switch (ib) {
		case 1:
			try {
				c.insert();
				c.display();
				cou.case2();
				break;

			} catch (Exception e) {
				System.out.println("**NOTE:Enter PROPER  FIELD (1 CHANCE)*");
				try {
					c.insert();
				} catch (Exception e1) {
					System.out.println("**NOTE:Enter PROPER FIELD (2 CHANCE)*");
					c.insert();
				}
			}

		case 2:
			c.display();
			cou.case2();
			break;

		case 3:
			f.insertf();
			f.displayf();
			cou.case2();
			break;

		case 4:
			f.displayf();
			cou.case2();
			break;

		case 5:
			b.insertB();
			b.displayB();
			cou.case2();
			break;

		case 6:
			b.displayB();
			cou.case2();
			break;

		case 7:
			cou.insertS();
			cou.displayS();
			cou.case2();
			break;

		case 8:
			cou.displayS();
			cou.case2();
			break;

		case 9:
			cou.Search();
			cou.case2();
			break;

		case 10:
			cou.case1();
			break;
		}
	}

	public static void main(String[] args) {
		Student s = new Student();

		s.case1();
	}

	static String sis;
	static int count;
	public void insertS() {

		int noOfLineb = 0;
		String is ;
		s = new Scanner(System.in);

		try {


			System.out.println("How many No. of Student you want to enter:");
			noOfLineb = s.nextInt();

			for (int i = 1; i <= noOfLineb; i++) {

				System.out.println("Enter " + i + "st Student ID:");

				is = "S0"+count++;

				System.out.println("Enter " + i + "st Student name:");

				String sa = s.next();
				b.displayB();
				System.out.println("Allocate  Batch ID  to " + sa + "  from above  :");
				sis = s.next();

				Student s = new Student();
				s.setSid(is);// 1111
				s.setSname(sa);// 2222

				Iterator<Batch> iter2 = array2.iterator();
				while (iter2.hasNext()) {
					Batch bb = iter2.next();
					if (bb.getBid().equals(sis)) {
						bb.getBid();// 111
						bb.getBname();// 222

						if (bb.getBid().equals(sis)) {

							s.setBatch(bb);//3333
							array3.add(s);
							System.out.println(array3);
						}



					}}

				System.out.println("*@" + sa + " entry SAVED@*");
			}
		} catch (Exception e) {
			s = new Scanner(System.in);

		}
	}

	public void displayS() {
		System.out.println("-----------********DETAILED Student   DISPLAY ********---------------");
		System.out.println("");
		System.out.println("Student ID     Student Name   Batch Name    Faculty Name    Course Name ");
		System.out.println(array3);
		Iterator<Student> itrs = array3.iterator();
		while (itrs.hasNext()) {
			Student ss = itrs.next();
	
			System.out.println(ss.getSid() + "                 " + ss.getSname()+ "                 " + ss.getBatch().getBname()+ "                  "
					+ ss.getBatch().getFaculty().getFname() + "                        " + ss.getBatch().getFaculty().getCorse().getName());
			System.out
			.println("----------------------------------------------------------------------");
		}




	}
	static	String search;
	public void Search() {
		System.out.println("Enter STUDENT name");
		search=s.next();
	

		Iterator<Student> itrs = array3.iterator();
		while (itrs.hasNext()) {
			Student ss = itrs.next();
			if (ss.getSname().equals(search)) {
				System.out.println("-----------********DETAILED   DISPLAY ********---------------");
				System.out.println("");
				System.out.println("Student ID     Student Name   Batch Name    Faculty Name    Course Name ");
				System.out.println(ss.getSid() + "                 " + ss.getSname()+ "                 " + ss.getBatch().getBname()+ "                  "
						+ ss.getBatch().getFaculty().getFname() + "                        " + ss.getBatch().getFaculty().getCorse().getName());
				System.out
				.println("----------------------------------------------------------------------");
				cou.case2();
			}
			Iterator<Batch> itrs2 = array2.iterator();
			while (itrs2.hasNext()) {
				Batch bb = itrs2.next();
				if( ss.getBatch().getBname().equals(search))
				{
					System.out.println("-----------********DETAILED   DISPLAY ********---------------");
					System.out.println("");
					System.out.println("Batch Id   Batch Name    Faculty Name    Course Name ");
					System.out.println(ss.getBatch().getBid()+"               "+ss.getBatch().getBname()+"                "+ss.getBatch().getFaculty().getFname()+"             "+ss.getBatch().getFaculty().getCorse().getName());
					System.out
					.println("----------------------------------------------------------------------");
					cou.case2();
				}
				Iterator<Faculty> itrs1 = array1.iterator();
				while (itrs1.hasNext()) {
					Faculty ff = itrs1.next();
					
					if(ss.getBatch().getFaculty().getFname().equals(search) ){
						System.out.println("-----------********DETAILED   DISPLAY ********---------------");
						System.out.println("");
						System.out.println("Faculty Id    Faculty Name    Course Name ALOCATED");
						System.out.println(ss.getBatch().getFaculty().getFid()+"                  "+ss.getBatch().getFaculty().getFname()+"              "+ss.getBatch().getFaculty().getCorse().getName());
						System.out
						.println("----------------------------------------------------------------------");
						cou.case2();
					}
					Iterator<Corse> itrs3 = array.iterator();
					while (itrs3.hasNext()) {
						Corse cc = itrs3.next();
					
						if(ss.getBatch().getFaculty().getCorse().getName().equals(search)) {
							System.out.println("-----------********DETAILED   DISPLAY ********---------------");
							System.out.println("");
							System.out.println(" Course ID    Course Name ");
		System.out.println(ss.getBatch().getFaculty().getCorse().getId()+"                   "+ss.getBatch().getFaculty().getCorse().getName());
		System.out
		.println("----------------------------------------------------------------------");
		cou.case2();
						}
					}}}
		}}	
}

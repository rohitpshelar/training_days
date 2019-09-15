package com.pro;

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
	public void insertB() {

		int noOfLineb = 0;

		s = new Scanner(System.in);

			try {
			

					System.out.println("How many No. of Batch you want to enter:");
					noOfLineb = s.nextInt();
		
				for (int i = 1; i <= noOfLineb; i++) {
				
						System.out.println("Your Batch ID is:");

						is = "b0"+count++;
				System.out.println(is);
					System.out.println("Enter Batch name for"+is+":");

					String sa = s.next();
					ff.displayf();
					System.out.println("Allocate  Faculty ID  to " + sa + "  from above  :");
					bis = s.next();
					String bbis=bis;
					
					Batch b = new Batch();
					b.setBid(is);// 11
					b.setBname(sa);// 22
					Iterator<Faculty> iter = array1.iterator();
					while (iter.hasNext()) {
						Faculty ff = iter.next();
							/*Iterator<Corse> itr = array.iterator();// =====
							while (itr.hasNext()) {
								Corse cc = itr.next();
								System.out.println(ff.getFid()+".equals(out)"+bis+"=="+ff.getFid().equals(bis));
							*/	if (ff.getFid().equals(bis)) {
									System.out.println(ff.getFid()+".equals(in)"+bis+"=="+ff.getFid().equals(bis));
								
								
									b.setFaculty(ff);// 33
									array2.add(b);
									System.out.println(array2);
								}

							
							}
				
					
					System.out.println("*@" + sa + " entry SAVED@*");
						}
					
				
			} catch (Exception e) {
				s = new Scanner(System.in);
				
			}
		
	}

	public void displayB() {
		System.out.println("-----------********DETAILED Batch   DISPLAY ********---------------");
		System.out.println("");
		System.out.println("Batch ID     Batch Name    Faculty Name    Course Name ");

		Iterator<Batch> itrb = array2.iterator();
		while (itrb.hasNext()) {
			Batch bb = itrb.next();
			bb.getBid();
		/*	Iterator<Faculty> itrf = array1.iterator();
			while (itrf.hasNext()) {
				Faculty ff = itrf.next();
				
				Iterator<Corse> itr = array.iterator();
				while (itr.hasNext()) {
					Corse cc = itr.next();
		*/	//	if (ff.getFid().equals(bis)) {
				
						System.out.println(bb.getBid() + "                 " +bb.getBname() + "                 " + bb.getFaculty().getFname()+ "                        " + bb.getFaculty().getCorse().getName());
						System.out.println("----------------------------------------------------------------------");
		//		}
				}
			}
		
	
}

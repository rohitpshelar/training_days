package com.pro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Faculty extends Corse {
	Corse cc = new Corse();

	ArrayList<Corse> array = (ArrayList<Corse>) cc.getArray();

	static  ArrayList<Faculty> array1 = new ArrayList<Faculty>();

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

	Integer noOfLine;
	Corse c =new Corse();
	String is;

	private Scanner s2;
static int count;
	public void insertf() {

		int noOfLine = 0;
		String is ;
		s2 = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			flag = false;
			try {
			

					System.out.println("How many No. of Faculty you want to enter:");
					noOfLine = s2.nextInt();
				
				for (int i = 1; i <= noOfLine; i++) {
				
						System.out.println("Your Faculty ID is:");

						is = "f0"+count++;
						System.out.println(is);
				
					System.out.println("Enter Faculty name for "+is+":");

					String sa = s2.next();
					c.display();
					System.out.println("Allocate  Courde ID  to " + sa + "  from above  :");
					fis = s2.next();
					String ffis =fis;
					Faculty fi = new Faculty();
					fi.setFid(is);// 1
					fi.setFname(sa);// 2
					Iterator<Corse> itr = array.iterator();// =====
					while (itr.hasNext()) {
						Corse cc = itr.next();
						System.out.println(cc.getId()+".equals(out)"+fis+"=="+cc.getId().equals(fis));
						
						if (cc.getId().equals(fis)) {
							System.out.println(cc.getId()+".equals(in)"+fis+"=="+cc.getId().equals(fis));
							
							cc.getId();
							cc.getName();
							fi.setCorse(cc);// 3
							array1.add(fi);
							System.out.println(array1);
						}
						
					}
					
					System.out.println(array1);
					System.out.println("*@" + sa + " entry SAVED@*");

				}
			} catch (Exception e) {
				s2 = new Scanner(System.in);
				flag = true;
			}
		}
	}

	public void displayf() {
		System.out.println("-----------********DETAILED  Faculty  DISPLAY ********---------------");
		System.out.println("");
		System.out.println("courseID    courseNAME  FacultyID    FacultyNAME ");

		Iterator<Faculty> itrf = array1.iterator();
		while (itrf.hasNext()) {
			Faculty ff = itrf.next();
		/*	Iterator<Corse> itr = .iterator();
			while (itr.hasNext()) {
				Corse cc = itr.next();
			*/
		//		if (cc.getId().equals(fis)) {
				
					System.out.println(ff.getCorse().getId() + "                      " + ff.getCorse().getName()
							+ "                       " + ff.getFid() + "                        " + ff.getFname());
					System.out.println("----------------------------------------------------------------------");
		//		}
			}
		}
	}



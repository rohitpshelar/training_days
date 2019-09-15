package com.pro;

import java.util.Iterator;
import java.util.Scanner;

public class Student {

public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
private	int sid;
private	String sname;

public void inserts() {

	int noOfLine = 0;
	Integer is = 0;
	Scanner s = new Scanner(System.in);
	boolean flag = true;
	while (flag) {
		flag = false;
		try {
			if (noOfLine == 0) {

				System.out.println("How many No. of Student you want to enter:");
				noOfLine = s.nextInt();
			}
			for (int i = 1; i <= noOfLine; i++) {
				if (is == 0) {
					System.out.println("Enter " + i + "st Student ID:");

					is = s.nextInt();
				}
				System.out.println("Enter " + i + "st Student name:");

				String sa = s.next();
				c.display();
				System.out.println("Allocate  Courde ID  to " + sa + "  from above  :");
				fis = s.nextInt();
				Faculty fi = new Faculty();
				Iterator iter = array1.iterator();
				while (iter.hasNext()) {
					Faculty ff=(Faculty) iter.next();
					
					Iterator<Corse> itr = array.iterator();// =====
					while (itr.hasNext()) {
						Corse cc = itr.next();
						if (ff.getCorse().getId() == fis) {
							cc.getId();
							cc.getName();
							fi.setCorse(cc);// 3
						}
					}
				}
				array2.add(fi);
				System.out.println("*@" + sa + " entry SAVED@*");

			}
		} catch (Exception e) {
			s = new Scanner(System.in);
			flag = true;
		}
	}
}
}

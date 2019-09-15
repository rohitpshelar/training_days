package com.pro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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

	public void insert() {

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
						
						is = "c0"+count++;
						System.out.println(is);
					} catch (Exception e) {
						System.out.println("**NOTE:Enter PROPER FIELD (in Second try)*");
					} finally {
						System.out.println("Enter Course name for "+is+":");
						String sa = s.next();
						Corse c = new Corse();
						c.setId(is);
						c.setName(sa);
						array.add(c);
						System.out.println("*SAVED*");
					}
				}
			} else {

				c.insert();
			}
		}
	}

	public void display() {
	
		System.out.println("----------********COURSE   AVAILABLE   ARE*******--------------");
		System.out.println("");
		System.out.println("ID    NAME");

		Iterator<Corse> itr = array.iterator();
		System.out.println(array);
		while (itr.hasNext()) {
		
			Corse name = itr.next();
			System.out.println(name.getId() + "    --   " + name.getName());
		}
		System.out.println("--------------------------------------------------------------------------");
	}
}

package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Object {
public static void main(String[] args) {
	

	ArrayList a = new ArrayList();
	Student rohit = new Student();
	rohit.setRollNo(1);
	rohit.setName("rohit");
	
	Student raza = new Student();
	raza.setRollNo(1);
	raza.setName("raza");
	
	Student don = new Student();
	don.setRollNo(1);
	don.setName("don");
	
	a.add(rohit);
	a.add(raza);
	a.add(don);
	
	
	Collections.sort(a,new CompareObject());
	
	Iterator i=a.iterator();
	while (i.hasNext()) {
		Student s1 = (Student) i.next();
		System.out.println(s1.getName());
	}
	
}

}

package com;

import java.util.ArrayList;
import java.util.Comparator;

public class CompareObject implements Comparator{

	public int compare(java.lang.Object o1, java.lang.Object o2) {
		Student s1=(Student)o1;  
		Student s2=(Student)o2;  
		  
		return s2.getName().compareTo(s1.getName());  
	}
	
	

}

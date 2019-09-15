package com.learn.day5;

public class Test {

	public static void main(String[] args) {

		Collegeall c = new Collegeall();
		Allform a = c.AllStudent();

		System.out.println(a.rohit.getRollno());
		System.out.println(a.rohit.getName());
		System.out.println(a.rohit.getCollege().getAreaname());
		System.out.println(a.rohit.getCollege().getCityname());
		System.out.println(  "");
		
		System.out.println(a.don.getRollno());
		System.out.println(a.don.getName());
		System.out.println(a.don.getCollege().getAreaname());
		System.out.println(a.don.getCollege().getCityname());
		

	}

}

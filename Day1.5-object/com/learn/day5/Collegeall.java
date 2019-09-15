package com.learn.day5;

public class Collegeall {

	public Allform AllStudent() {
		Allform al = new Allform();

		al.rohit.setRollno(1);
		al.rohit.setName("Rohit");

		College col = new College();
		col.setAreaname("Katraj");
		col.setCityname("Pune");

		al.rohit.setCollege(col);

		al.don.setRollno(2);
		al.don.setName("Don");

		College co = new College();
		co.setAreaname("Nahre");
		co.setCityname("Mumbai");

		al.don.setCollege(co);

		return al;
	}

}

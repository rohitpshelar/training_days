package com.depu.shwetu;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
Configuration cfg=new Configuration();
cfg=cfg.configure();
System.out.println("Configration done");

SessionFactory sf=cfg.buildSessionFactory();
org.hibernate.Session s = sf.openSession();
System.out.println("Session Done");

Student stu = new Student();
stu.setRollno(5);
stu.setName("Dons");
System.out.println("Student Object Created n updated");

s.save(stu);
s.beginTransaction().commit();
System.out.println("Sucess");
	}

}

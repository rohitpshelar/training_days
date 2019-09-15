package com.spring.learn;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Student {

int rollno;
String name;


	public void setName(String name) {
	this.name = name;
}


public void setRollno(int rollno) {
	this.rollno = rollno;
}


	public static void main(String[] args) {
	
		Resource r= new ClassPathResource("applicationContext.xml");
		BeanFactory bf= new XmlBeanFactory(r);
		
		Student s = (Student) bf.getBean("Stu");
		System.out.println(s.rollno);
		System.out.println(s.name);

	}

}

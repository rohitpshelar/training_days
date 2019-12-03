package com.spring.learn;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.spring.ConnectiorInterface;


public class CallingClass {
	public static void main(String[] args) {
		
		Resource r = new ClassPathResource("applicationContext.xml");
		
		ConnectiorInterface cf= (ConnectiorInterface) new XmlBeanFactory(r).getBean("x");
		cf.commit();
	}

}

package com.spring.learn;

import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.ConnectiorInterface;

import jdk.internal.loader.Resource;

public class CallingClass {
	public static void main(String[] args) {
		
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory bf=new XmlBeanFactory(r);
		
		ConnectiorInterface cf= (ConnectiorInterface) bf.getBean("x");
		cf.commit();
	}

}

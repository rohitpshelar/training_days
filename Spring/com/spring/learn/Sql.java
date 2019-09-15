package com.spring.learn;

import com.spring.ConnectiorInterface;

public class Sql implements ConnectiorInterface {

	public void commit() {
		System.out.println("in SQL");
		
	}
	

}

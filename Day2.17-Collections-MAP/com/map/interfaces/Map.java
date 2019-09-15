package com.map.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Map {
	public static void main(final String[] args) {

		final HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(3, "rohit");
		hm.put(2, "aaaa");
		hm.put(1, "cccc");
		 
		ArrayList a = new ArrayList();
		
		final Set<Integer> key = hm.keySet();
	
		final Iterator<Integer> iter = key.iterator();
		while (iter.hasNext()) {
			final Integer keyi = iter.next();
			System.out.println(keyi);
			
			final String value = hm.get(keyi);
			System.out.println(value);
			a.add(value);
		}
		
		Collections.sort(a);
		System.out.println(a)
		
	
	}
}
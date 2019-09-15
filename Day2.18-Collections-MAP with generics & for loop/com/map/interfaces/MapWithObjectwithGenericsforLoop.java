package com.map.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MapWithObjectwithGenericsforLoop {

	public static void main(String[] args) {
		HashMap<String,HashMap<String, ArrayList<String>>> world = new HashMap<String,HashMap<String, ArrayList<String>>>();
				HashMap<String, ArrayList<String>> country1 = new HashMap<String, ArrayList<String>>();
					ArrayList<String> state1 = new ArrayList<String>();
					state1.add("City1");
					state1.add("City2");
					ArrayList<String> state2 = new ArrayList<String>();
					state2.add("City3");
					state2.add("City4");		
						country1.put("state1", state1);
						country1.put("state2", state2);
				
				HashMap<String, ArrayList<String>> country2 = new HashMap<String, ArrayList<String>>();
					ArrayList<String> state3 = new ArrayList<String>();
					state3.add("City5");
					state3.add("City6");		
					country2.put("state3", state3);

		
					
					
					world.put("country2", country2);
					world.put("country1", country1);
				
		// ======================================

		Set<String> keys = world.keySet();
		System.out.println(keys);//[country2, country1]
		
		for(String key:keys){
			System.out.println("");
			System.out.println(key);//country2
			HashMap<String, ArrayList<String>> h=world.get(key);
			Set<String> keys2 = h.keySet();
			System.out.println(keys2);//[state3]
			for (String key2 : keys2) {
				ArrayList<String> a= h.get(key2);
				System.out.println(key2+"=="+a);//[City5, City6]
				for (String s : a) {
					System.out.println(s);//City5
					
				}
				
			}
		}
		
		
		
		
		
	/*	System.out.println(key);// [India, USA]
		Iterator itr = key.iterator();
		while (itr.hasNext()) {
			System.out.println("");
			String sstate = (String) itr.next();
			System.out.println(sstate);// India
			HashMap hstate = (HashMap) hm.get(sstate);
			System.out.println(" " + hstate);// {Rajastan=[rajastan, unchal]
			Set key2 = hstate.keySet();
			System.out.println("  " + key2);// [Rajastan, Maharashtra]
			Iterator itr2 = key2.iterator();
			while (itr2.hasNext()) {
				String cString = (String) itr2.next();
				System.out.println("   STATE: =" + cString);// Rajastan
				ArrayList hstate22 = (ArrayList) hstate.get(cString);
				System.out.println("    " + hstate22);// [rajastan, unchal]
				Iterator iter = hstate22.iterator();
				while (iter.hasNext()) {
					String v3 = (String) iter.next();
					System.out.println("     CITY:==" + v3);// rajastan

				}

			}}*/

		

	}}


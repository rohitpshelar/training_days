package com.map.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapWithObject {

	public static void main(String[] args) {
		ArrayList<String> mh = new ArrayList<String>();
		mh.add("Pune");
		mh.add("Mumbai");
		ArrayList<String> raj = new ArrayList<String>();
		raj.add("rajastan");
		raj.add("unchal");
		ArrayList<String> usa = new ArrayList<String>();
		usa.add("London");
		usa.add("Paris");

		HashMap<String, ArrayList<String>> ihm = new HashMap<String, ArrayList<String>>();
		ihm.put("Maharashtra", mh);
		ihm.put("Rajastan", raj);
		HashMap<String, ArrayList<String>> uhm = new HashMap<String, ArrayList<String>>();
		uhm.put("USE", usa);

		HashMap<String, HashMap<String, ArrayList<String>>> hm = new HashMap<String, HashMap<String, ArrayList<String>>>();
		hm.put("India", ihm);
		hm.put("USA", uhm);
		// ======================================

		Set<String> key = hm.keySet();
		System.out.println(key);// [India, USA]
		Iterator<String> itr = key.iterator();
		while (itr.hasNext()) {
			System.out.println("");
			String sstate = itr.next();
			System.out.println(sstate);// India
			HashMap<?, ?> hstate = hm.get(sstate);
			System.out.println(" " + hstate);// {Rajastan=[rajastan, unchal]
			Set<?> key2 = hstate.keySet();
			System.out.println("  " + key2);// [Rajastan, Maharashtra]
			Iterator<?> itr2 = key2.iterator();
			while (itr2.hasNext()) {
				String cString = (String) itr2.next();
				System.out.println("   STATE: =" + cString);// Rajastan
				ArrayList<?> hstate22 = (ArrayList<?>) hstate.get(cString);
				System.out.println("    " + hstate22);// [rajastan, unchal]
				Iterator<?> iter = hstate22.iterator();
				while (iter.hasNext()) {
					String v3 = (String) iter.next();
					System.out.println("     CITY:==" + v3);// rajastan

				}

			}

		}

	}
}

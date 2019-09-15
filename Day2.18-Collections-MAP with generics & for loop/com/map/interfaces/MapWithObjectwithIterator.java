package com.map.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapWithObjectwithIterator {

	public static void main(String[] args) {
		ArrayList mh = new ArrayList();
		mh.add("Pune");
		mh.add("Mumbai");
		ArrayList raj = new ArrayList();
		raj.add("rajastan");
		raj.add("unchal");
		ArrayList usa = new ArrayList();
		usa.add("London");
		usa.add("Paris");

		HashMap ihm = new HashMap();
		ihm.put("Maharashtra", mh);
		ihm.put("Rajastan", raj);
		HashMap uhm = new HashMap();
		uhm.put("USE", usa);

		HashMap hm = new HashMap();
		hm.put("India", ihm);
		hm.put("USA", uhm);
		// ======================================

		Set key = hm.keySet();
		System.out.println(key);// [India, USA]
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

			}

		}

	}
}

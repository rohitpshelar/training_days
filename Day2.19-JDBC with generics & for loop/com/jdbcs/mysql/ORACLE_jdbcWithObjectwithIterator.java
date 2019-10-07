package com.jdbcs.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ORACLE_jdbcWithObjectwithIterator {

	public static void main(String[] args) {
		ArrayList<String> mh = new ArrayList<String>();
		mh.add("Pune");
		mh.add("Mumbai");
		ArrayList<String> raj = new ArrayList<String>();
		raj.add("Jothpur");
		raj.add("Ranchi");
		ArrayList<String> usa = new ArrayList<String>();
		usa.add("London");
		usa.add("Paris");

		HashMap<String,ArrayList<String>> ihm = new HashMap<String,ArrayList<String>>();
		ihm.put("Maharashtra", mh);
		ihm.put("Rajastan", raj);
		HashMap<String,ArrayList<String>> uhm = new HashMap<String,ArrayList<String>>();
		uhm.put("USE", usa);

		HashMap<String,	HashMap<String,ArrayList<String>>> hm = new HashMap<String,	HashMap<String,ArrayList<String>>>();
		hm.put("India", ihm);
		hm.put("USA", uhm);
		// ======================================

		Set<String> key = hm.keySet();
		System.out.println(key);// [India, USA]
		Iterator<String> itr = key.iterator();
		while (itr.hasNext()) {
			System.out.println("");
			String sstate = (String) itr.next();
			System.out.println("Country: =" + sstate);// India
			HashMap<?, ?> hstate = (HashMap<?, ?>) hm.get(sstate);
			Set<?> key2 = hstate.keySet();
			Iterator<?> itr2 = key2.iterator();
			while (itr2.hasNext()) {
				String cString = (String) itr2.next();
				System.out.println("     STATE: =" + cString);// Rajastan
				ArrayList<?> hstate22 = (ArrayList<?>) hstate.get(cString);
				Iterator<?> iter = hstate22.iterator();
				while (iter.hasNext()) {
					String v3 = (String) iter.next();
					System.out.println("        CITY:==" + v3);// joyhpur

					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						System.out.println("login==Driver loaded");
						
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "system","Rr89561$");												
						System.out.println("login==Connection extablish");
						
						CallableStatement cs=con.prepareCall("{call Sss(?,?,?)}");
						cs.setString(1, sstate);
						cs.setString(2, cString);
						cs.setString(3, v3);
						cs.execute();

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		}

	}
}

package com.jdbcs.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MYSQL_jdbcWithObjectwithIterator {

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
					System.out.println("        CITY:==" + v3);// rajastan

					try {
						Class.forName("com.mysql.jdbc.Driver");
						//System.out.println("login==Driver loaded");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","root");
						//System.out.println("login==Connection extablish");

						// String sql="insert into world value('don','rohit','rrr')";
						String sql = "insert into world value(?,?,?)";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, sstate);
						pst.setString(2, cString);
						pst.setString(3, v3);
						pst.addBatch();
//						pst.setString(1, sstate);
//						pst.setString(2, cString);// for 2 times entry
//						pst.setString(3, v3);
//						pst.addBatch();
						pst.executeBatch();
						
						//pst.execute();
						con.close();

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		}

	}
}

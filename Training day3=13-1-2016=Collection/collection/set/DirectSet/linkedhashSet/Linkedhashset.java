package collection.set.DirectSet.linkedhashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Linkedhashset {

	public static void main(String[] args) {
		ArrayList<String> mh = new ArrayList<String>();
		mh.add("Pune");
		mh.add("satara");
		mh.add("Pune");

		ArrayList<String> delhi = new ArrayList<String>();
		delhi.add("jarkhand");

		ArrayList<ArrayList<String>> india = new ArrayList<ArrayList<String>>();
		india.add(mh);
		india.add(delhi);

		ArrayList<String> londan = new ArrayList<String>();
		londan.add("LA");
		londan.add("Sanfrisco");

		ArrayList<String> Paris = new ArrayList<String>();
		Paris.add("phil");
		Paris.add("LA");

		ArrayList<ArrayList<String>> usa = new ArrayList<ArrayList<String>>();
		usa.add(londan);
		usa.add(Paris);

		ArrayList<ArrayList<ArrayList<String>>> country = new ArrayList<ArrayList<ArrayList<String>>>();
		country.add(india);
		country.add(usa);

		System.out.println("USING HASHSET");
		Iterator itr = country.iterator();
		while (itr.hasNext()) {
			ArrayList hi = (ArrayList) itr.next();
			LinkedHashSet hs = new LinkedHashSet(hi);
			System.out.println("State==" + hs);
			Iterator itr1 = hs.iterator();
			while (itr1.hasNext()) {
				ArrayList hi1 = (ArrayList) itr1.next();
				LinkedHashSet hs1 = new LinkedHashSet(hi1);
				System.out.println("City" + hs1);
				Iterator itr2 = hs1.iterator();
				while (itr2.hasNext()) {
					String hi2 = (String) itr2.next();
					System.out.println("City=====" + hi2);

				}
			}
		}
	}
}

package collection.set.DirectSet.hashset.withArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class WithArray {


	public static void main(String[] args) {
		//WithArray withArray = new WithArray();



		ArrayList<ArrayList<ArrayList<String>>> country=new ArrayList<ArrayList<ArrayList<String>>>();
		ArrayList<String> mh=new ArrayList<String>();
		mh.add("Pune");
		mh.add("satara");
		mh.add("Pune");
		ArrayList<String> delhi=new ArrayList<String>();
		delhi.add("jarkhand");
		ArrayList<ArrayList<String>>  india=new ArrayList<ArrayList<String>>();
		india.add(mh);
		india.add(delhi);

		ArrayList<ArrayList<String>> usa=new ArrayList<ArrayList<String>>();		
		ArrayList<String> londan=new ArrayList<String>();
		londan.add("LA");
		londan.add("Sanfrisco");
		ArrayList<String> Paris=new ArrayList<String>();
		Paris.add("phil");
		Paris.add("LA");
		usa.add(londan);
		usa.add(Paris);

		country.add(india);
		country.add(usa);


	


		System.out.println("USING HASHSET");
		Iterator itr=  country.iterator();
		while (itr.hasNext()) {
		ArrayList hi=	(ArrayList) itr.next();
		HashSet hs=new HashSet(hi);
		System.out.println("State=="+hs);
		Iterator itr1=  hs.iterator();
		while (itr1.hasNext()) {
			ArrayList hi1=	(ArrayList) itr1.next();
			HashSet hs1=new HashSet(hi1);
		System.out.println("City"+hs1);
		Iterator itr2=  hs1.iterator();
		while (itr2.hasNext()) {
		String hi2=	(String) itr2.next();
		System.out.println("City====="+hi2);
		
		}
		}
		}
		


	}
}

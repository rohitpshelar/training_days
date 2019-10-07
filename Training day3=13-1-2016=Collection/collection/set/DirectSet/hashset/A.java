package collection.set.DirectSet.hashset;

import java.util.HashSet;
import java.util.Iterator;

public class A {
	
	public static void main(String[] args) {
		
		HashSet<HashSet<HashSet<String>>> country=new HashSet<HashSet<HashSet<String>>>();
		
		HashSet<HashSet<String>> india=new HashSet<HashSet<String>>();
		
		HashSet<String> mh=new HashSet<String>();
		mh.add("Pune");
		mh.add("satara");
		mh.add("Pune");
		
		HashSet<String> delhi=new HashSet<String>();
		delhi.add("jarkhand");
		
		india.add(mh);
		india.add(delhi);
	
		
		HashSet<HashSet<String>> usa=new HashSet<HashSet<String>>();
		
		HashSet<String> londan=new HashSet<String>();
		londan.add("LA");
		londan.add("Sanfrisco");
		
		HashSet<String> Paris=new HashSet<String>();
		Paris.add("phil");
		Paris.add("LA");
		
		usa.add(londan);
		usa.add(Paris);
		
		country.add(india);
		country.add(usa);
		
		System.out.println("USING HASHSET");
		Iterator<HashSet<HashSet<String>>> itr=  country.iterator();
		while (itr.hasNext()) {
		HashSet<?> hi=	(HashSet<?>) itr.next();
		System.out.println("State=="+hi);
		Iterator<?> itr1=  hi.iterator();
		while (itr1.hasNext()) {
		HashSet<?> hi1=	(HashSet<?>) itr1.next();
		System.out.println("City"+hi1);
		Iterator<?> itr2=  hi1.iterator();
		while (itr2.hasNext()) {
		String hi2=	(String) itr2.next();
		System.out.println("City====="+hi2);
		
		}
		}
		}
		
	}

}

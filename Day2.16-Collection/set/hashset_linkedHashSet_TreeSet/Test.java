package set.hashset_linkedHashSet_TreeSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		ArrayList<Comparable> arrayList = new ArrayList<Comparable>();
		arrayList.add(2);
		arrayList.add(1);
		arrayList.add(5);
		arrayList.add(29);
		arrayList.add(2);
	/*	arrayList.add("rohit");
		arrayList.add("don");
		arrayList.add("java");
		arrayList.add("poo");
		arrayList.add("rohit");
		arrayList.add("cjc");*/
		System.out.println("ArrayList=" + arrayList);
		
		System.out.println("");
		System.out.println("Dublicate value are removed-/-without sorting");
		HashSet<Comparable> hs = new HashSet<Comparable>(arrayList);
		System.out.println("So HashList=" + hs);

		System.out.println("");
		System.out.println("Dublicate value are removed-/-without sorting-/-but same as array");
		LinkedHashSet<Comparable> lhs = new LinkedHashSet<Comparable>(arrayList);
		System.out.println("So LinkedHashSet=" + lhs);
		

	}
}

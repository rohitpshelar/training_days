package collection.set.pojoWithSet.hashset;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		ObjectCalling oc = new ObjectCalling();

		ArrayList<?> a = oc.m1();

		Iterator<?> itr = a.iterator();
		while (itr.hasNext()) {
			Student s = (Student) itr.next();
			System.out.println(s.getRollno());
			System.out.println(s.getName());
			System.out.println(s.getAddress().getCity());
			System.out.println("------------");
		}
	}
}

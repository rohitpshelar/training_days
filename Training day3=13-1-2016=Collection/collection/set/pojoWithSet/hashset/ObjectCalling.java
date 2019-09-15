package collection.set.pojoWithSet.hashset;

import java.util.ArrayList;

public class ObjectCalling {
	public ArrayList<Student> m1() {
		ArrayList<Student> a = new ArrayList<Student>();
		
		Student rohit = new Student();
		rohit.setRollno(1);
		rohit.setName("Rohit");
		Address ad = new Address();
		ad.setCity("Pune");
		rohit.setAddress(ad);

		Student raza = new Student();
		raza.setRollno(2);
		raza.setName("raza");
		raza.setAddress(ad);
		
		
		Student chetan = new Student();
		chetan.setRollno(3);
		chetan.setName("chetan");
		Address ad1 = new Address();
		ad1.setCity("Village");
		chetan.setAddress(ad1);
		
		
		a.add(rohit);
		a.add(raza);
		a.add(chetan);
		
		return a;
	}
public static void main(String[] args) {
	ObjectCalling oc = new ObjectCalling();
	
	ArrayList a=oc.m1();
}
}

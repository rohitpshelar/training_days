package list.arrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	ArrayList<Student> m1() {
		ArrayList<Student> al = new ArrayList<Student>();

		Student r = new Student();
		r.name = "Rohit";
		r.rollno = 1;
		al.add(r);
		
		Student zd = new Student();
		zd.name = "Zen";
		zd.rollno = 9;
		al.add(zd);
		
		Student d = new Student();
		d.name = "Don";
		d.rollno = 6;
		al.add(d);
		

		
		return al;
	}

	public static void main (String[] args) {

		System.out.println("");
		System.out.println("Integer==iterator");
		ArrayList<Integer> am = new ArrayList<Integer>();
		am.add(5);
		am.add(10);
		am.add(22);
		Iterator<Integer> im = am.iterator();
		while (im.hasNext()) {
			Integer integer = im.next();
			System.out.println(integer);
		}

		System.out.println("");
		System.out.println("String==iterator");
		ArrayList<String> sa = new ArrayList<String>();
		sa.add("rohit");
		sa.add("Don");
		sa.add("mad");
		Iterator<String> si = sa.iterator();
		while (si.hasNext()) {
			String string = si.next();
			System.out.println(string);
		}

		System.out.println("");
		System.out.println("Method==iterator");
		Test t = new Test();
		ArrayList<Student> al = t.m1();
		Iterator<Student> itr = al.iterator();
		while (itr.hasNext()) {
			Student s = itr.next();
			System.out.println(s.rollno);
			System.out.println(s.name);
		}

		System.out.println("");
		System.out.println("Multiple array==iterator");
		ArrayList<String> stateMaharashtra = new ArrayList<String>();
		stateMaharashtra.add("Pune");
		stateMaharashtra.add("Mumbai");
		ArrayList<String> stateHydrabad = new ArrayList<String>();
		stateHydrabad.add("Tumil Nadu");
		stateHydrabad.add("UP");
		ArrayList<String> statelondon = new ArrayList<String>();
		statelondon.add("LA");
		statelondon.add("Cochin");
		ArrayList<String> stateparis = new ArrayList<String>();
		stateparis.add("Aston");
		stateparis.add("Charls");

		ArrayList<ArrayList<String>> countryIndia = new ArrayList<ArrayList<String>>();
		countryIndia.add(stateMaharashtra);
		countryIndia.add(stateHydrabad);
		ArrayList<ArrayList<String>> countryUSA = new ArrayList<ArrayList<String>>();
		countryUSA.add(statelondon);
		countryUSA.add(stateparis);

		ArrayList<ArrayList<ArrayList<String>>> arl = new ArrayList<ArrayList<ArrayList<String>>>();
		arl.add(countryIndia);
		arl.add(countryUSA);

		System.out.println("Country==" + arl);
		Iterator<ArrayList<ArrayList<String>>> country = arl.iterator();
		while (country.hasNext()) {
			ArrayList<?> state = country.next();
			System.out.println("");
			System.out.println("State==" + state);
			Iterator<?> statei = state.iterator();
			while (statei.hasNext()) {
				ArrayList<?> city = (ArrayList<?>) statei.next();
				System.out.println("City==" + city);
				Iterator<?> cityi = city.iterator();
				while (cityi.hasNext()) {
					String citys = (String) cityi.next();
					System.out.println(citys);
				}

			}
		}

		/*
		 * System.out.println(""); System.out.println("String &
		 * Integer==iterator"); ArrayList isa = new ArrayList(); isa.add(3);
		 * isa.add(2); isa.add("rohit"); isa.add("Don"); isa.add("mad");
		 * Iterator sii = isa.iterator(); while (sii.hasNext()) { if (sii
		 * instanceof String) { String stringi = (String) sii.next();
		 * System.out.println(stringi); } }
		 */

	}
}

package test;

import java.util.ArrayList;
import java.util.List;

public class ObjCompare {
	
	public static void main(String[] args) {
		List<Object> l = SendString();
		
		for (int i = 0; i < l.size(); i++) {
			if(l.get(i).equals(new String())) {
				System.out.println("its String");
			}else {
				System.out.println("its Int");
			}
		}
		
	}
	
	
	
	static List<Object> SendString() {
		List<Object> l = new ArrayList<Object>();
		l.add("rohit");
		return l;

	}

	static List<Integer> SendInt() {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		return l;

	}
}

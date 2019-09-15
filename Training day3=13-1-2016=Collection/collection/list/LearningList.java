package collection.list;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class LearningList {

	public static void main(String[] args) {

	ArrayList<String> list = new ArrayList<String>();
		list.add("rohiit");
		list.add("tathagat");
		list.add("niraj");
		list.add("chetan");
		list.add("dhiraj");
		list.add("rohiit");
		list.add("kunal");
		list.add("121");

		System.out.println("ArrayList === " + list);
		final LinkedHashSet<String> hashSet = new LinkedHashSet<String>(list);
		System.out.println("LinkedHashSet ==== " + hashSet);

	}

}

package list.arrayList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Multiple_list_sortUsingComparator {

	private static List<patient> getPatientList() {
		List<patient> pl = new ArrayList<patient>();
		pl.add(new patient("C", "g"));
		pl.add(new patient("A", "a"));
		pl.add(new patient("G", "e"));
		pl.add(new patient("E", "c"));
		return pl;
	}

	private static List<employees> getEmployeeList() {
		List<employees> pl = new ArrayList<employees>();
		pl.add(new employees("F", "d"));
		pl.add(new employees("D", "b"));
		pl.add(new employees("B", "h"));
		pl.add(new employees("H", "f"));
		return pl;
	}

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
//		List<employees> el = getEmployeeList();
//		Collections.sort(el, Comparator.comparing(employees::getName));
//		el.forEach(e -> System.out.println(e));
//
//		List<patient> pl = getPatientList();
//		Collections.sort(pl, Comparator.comparing(patient::getName));
//		pl.forEach(e -> System.out.println(e));
//		

		// ====================================================

		List<Object> merged = new ArrayList(getPatientList());
		merged.addAll(getEmployeeList());

		Collections.sort(merged, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				Method[] m = o1.getClass().getMethods();
				for (Method method : m) {
					if ((method.getName().equals("getName"))) {
						String st = null;
						try {
							st = (String) method.invoke(o1, null);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
							e1.printStackTrace();
						}
						Method[] m2 = o2.getClass().getMethods();
						for (Method method2 : m2) {
							if ((method2.getName().equals("getName"))) {
								try {
									String st1 = (String) method2.invoke(o2, null);
									return st.compareTo(st1);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			return 0;
			}
		});
		
		for (Object object : merged) {
			System.out.println(object);
		}

	}

}

class patient {

	String name;
	String key;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public patient(String name) {
		super();
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public patient(String name, String key) {
		super();
		this.name = name;
		this.key = key;
	}

	@Override
	public String toString() {
		return "patient [name=" + name + ", key=" + key + "]";
	}

}

class employees {

	String name;
	String key;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public employees(String name) {
		super();
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public employees(String name, String key) {
		super();
		this.name = name;
		this.key = key;
	}

	@Override
	public String toString() {
		return "employees [name=" + name + ", key=" + key + "]";
	}
}

package list.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class rohit_comparator {
	
	private List<Employee> getList() {
		List<Employee> l = new ArrayList<Employee>();
		l.add(new Employee(9, "Rohit", "xomi"));
		l.add(new Employee(5, "Rohit", "Shelar"));
		l.add(new Employee(4, "Rohit", "Shelar"));
		l.add(new Employee(1, "Don", "que"));
		l.add(new Employee(6, "zom", "bom"));
		l.add(new Employee(7, "tom", "lop"));
//		l.add(new Employee(8, null, "zop"));
//		l.add(new Employee(3, null, "lop"));
//		l.add(new Employee(2, "Zom", null));
//		l.add(new Employee(5, "tom", null));
		return l;
	}
	
	public static void main(String[] args) {
		List<Employee> t = new rohit_comparator().getList();
		
//		first name comparator
//		Comparator<Employee> compareByFirstName =Comparator.comparing( Employee::getFirstName );
//		Collections.sort(t, compareByFirstName);
//		t.forEach(Employee -> System.out.println(Employee)); 
		
//		------------------------------------------------------------------
		
//		first name comparator
//		Comparator<Employee> compareByFirstName =Comparator.comparing( Employee::getFirstName );
//
//		last name comparator
//		Comparator<Employee> compareByLastName = Comparator.comparing( Employee::getLastName );
//		 
//		Compare by first name and then last name (multiple fields)
//		Comparator<Employee> compareByFullName = compareByFirstName.thenComparing(compareByLastName);
//		 
//		Use Comparator
//		Collections.sort(t, compareByFirstName);
//		
//		t.forEach(Employee -> System.out.println(Employee)); 

//		------------------------------------------------------------------------
	
//		Comparator<Employee> compareById =Comparator.comparing( Employee::getId );
//
//		Comparator<Employee> compareByFirstName =Comparator.comparing( Employee::getFirstName );
//
//		Comparator<Employee> compareByLastName = Comparator.comparing( Employee::getLastName );
//		 
//		Comparator<Employee> compareByFullNameId = compareById.thenComparing(compareByFirstName.thenComparing(compareByLastName));
//		 
//		Collections.sort(t, compareByFullNameId);
//		t.forEach(Employee -> System.out.println(Employee)); 
		

//		--------------Same as Above----------------------------------------------------------
		
		Collections.sort(t, Comparator.comparing(Employee::getId).thenComparing(Comparator.comparing(Employee::getFirstName).thenComparing(Comparator.comparing(Employee::getLastName))));
		t.forEach(Employee -> System.out.println(Employee)); 
		
	}
}

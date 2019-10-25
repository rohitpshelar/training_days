package list.arrayList;

public class Employee {

	int Id;
	String FirstName;
	String LastName;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + "]";
	}
	public Employee(int id, String firstName, String lastName) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
	}
	
	
}

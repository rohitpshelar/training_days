package collection.set.pojoWithSet.hashset;

public class Student {

	private int rollno;
	private String name;
	private Address address;
	
	public Address getAddress(){
		
		return address;
	}
	
	public void setAddress(Address address){
		
		this.address=address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	
}

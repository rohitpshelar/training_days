package com.javatpoint;

public class Employee {
private int id;
private String name;
private Address address;

public Employee() {System.out.println("def cons");}

/*public Employee(int id) {this.id = id;}

public Employee(String name) {	this.name = name;}

public Employee(int id, String name) {
	this.id = id;
	this.name = name;
}
*/
public Employee(int id, String name, Address address) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
}

void show(){
	System.out.println(toString());
}

@Override
public String toString() {
	return " {\n\t \"Employee\" : { \n\t\t\"id \" : \"" + id + "\",\n\t\t\"name \" : \"" + name
			+ "\",\n\t\t\"address \" : \"" + address + "\" \n}\n}";
}



}

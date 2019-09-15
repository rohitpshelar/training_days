package com.day1.learm;

public class ConstructorCallWhenObjectIsCreated {

	private void aa() {
		System.out.println("aa====ConstructorCallWhenObjectIsCreated");

	}
	{
		System.out.println("INSIDE ConstructorCallWhenObjectIsCreated3");
	}
	public static void main(String[] args) {
		
		ConstructorCallWhenObjectIsCreated c = new ConstructorCallWhenObjectIsCreated();
		c.aa();
		ConstructorCallWhenObjectIsCreated c2 = new ConstructorCallWhenObjectIsCreated();
		

	}
	{
		System.out.println("INSIDE ConstructorCallWhenObjectIsCreated");
	}
	{
		System.out.println("INSIDE ConstructorCallWhenObjectIsCreated2");
	}
}

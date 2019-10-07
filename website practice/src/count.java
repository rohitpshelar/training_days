
public class count {
	// Naive Solution to find if count of divisors is
	// even or odd
	
	 
	// Function to count the divisors
	public  static void countDivisors(int n)
	{
	    // Initialize count of divisors
	    int count = 0;
	 
	    // Note that this loop runs till square root
	    for (int i=1; i<=(n)+1; i++)
	    {
	        if (n%i==0)
	 
	            // If divisors are equal,increment
	            // count by one
	            // Otherwise increment count by 2
	            count += (n/i == i)? 1 : 2;
	    }
	 
	    if (count%2==0)
	        System.out.println("Even\n");
	    else
	    	 System.out.println("Odd\n");
	}
	
	
	
	private static void mycounter(int i) {
		if(i%2==0)
			 System.out.println("Even\n");
			    else
			    	
		System.out.println("Odd\n");
		

	}
	 
	/* Driver program to test above function */
	public static void main(String[] args) {
		
	
		 System.out.println("The count of divisors of 10 is: \n");
	   // countDivisors(10);
	    mycounter(125);
	   
	}

}

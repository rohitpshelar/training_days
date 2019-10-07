
public class count {
	// Naive Solution to find if count of divisors is
	// even or odd
	#include <bits/stdc++.h>
	 
	// Function to count the divisors
	void countDivisors(int n)
	{
	    // Initialize count of divisors
	    int count = 0;
	 
	    // Note that this loop runs till square root
	    for (int i=1; i<=sqrt(n)+1; i++)
	    {
	        if (n%i==0)
	 
	            // If divisors are equal,increment
	            // count by one
	            // Otherwise increment count by 2
	            count += (n/i == i)? 1 : 2;
	    }
	 
	    if (count%2==0)
	        printf("Even\n");
	    else
	        printf("Odd\n");
	}
	 
	/* Driver program to test above function */
	int main()
	{
	    printf("The count of divisors of 10 is: \n");
	    countDivisors(10);
	    return 0;
	}

}

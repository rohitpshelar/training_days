package creationalDesignPatterns.factoryMethodPattern;

import java.io.*;

class main {
	public static void main(String args[]) throws IOException {
		GetPlanFactory planFactory = new GetPlanFactory();

		System.out.println("Enter the name of plan No. for which the bill will be generated: ");
		System.out.println("1. DOMESTICPLAN (rate : 3.50)");
		System.out.println("2. COMMERCIALPLAN (rate : 7.50)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String planNo = br.readLine();
		String planName = null;
		if (planNo.equals("1"))
			planName = "DOMESTICPLAN";
		else if (planNo.equals("2"))
			planName = "COMMERCIALPLAN";
		else {
			System.err.println("Wrong No. entered");
			System.exit(0);
		}
		System.out.print("Enter the number of units for bill will be calculated: ");
		int units = Integer.parseInt(br.readLine());

		Plan p = planFactory.getPlan(planName);
		// call getRate() method and calculateBill()method of DomesticPaln.

		System.out.print("Bill amount for " + planName + " of  " + units + " units is: ");
		


		p.getRate();
		p.calculateBill(units);
	}
}

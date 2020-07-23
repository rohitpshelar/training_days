package test;

public class XSS {

	public static String getValueFromgetParameterORgetAttribute(String getParameterValue, Object getAttributeValue) {

		String paramVar = getParameterValue;

		if (paramVar == null && getAttributeValue != null) {
			paramVar = String.valueOf(getAttributeValue);
		}

		return paramVar;

	}

	private void executeXSS() {
		long startTime = System.currentTimeMillis();

		/* ... the code being measured starts ... */

		for (Integer i = 0; i < 100; i++) {
			XSS.getValueFromgetParameterORgetAttribute(new Integer(i).toString(), new Integer(i).toString());
			XSS.getValueFromgetParameterORgetAttribute(new Integer(i).toString(), new Integer(i).toString());
			XSS.getValueFromgetParameterORgetAttribute(new Integer(i).toString(), new Integer(i).toString());
		}

		/* ... the code being measured ends ... */

		long endTime = System.currentTimeMillis();

		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in milliseconds: " + timeElapsed);

	}

	public static void main(String[] args) throws InterruptedException {

		new XSS().executeXSS();
	}
}

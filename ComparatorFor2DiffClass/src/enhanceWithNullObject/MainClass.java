package enhanceWithNullObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		List<Bean> l = new ArrayList<Bean>();
		l.add(new Bean(1, "Rohit"));
		l.add(new Bean((Integer) null, null));
		//l.add(null);
		l.add(new Bean(2, "DAS"));
		
		for (Bean bean : l) {
			System.out.println(bean.id);
			
		}
		
	}
	
}

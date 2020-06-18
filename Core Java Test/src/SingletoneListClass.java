import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SingletoneListClass {
	public static void main(String[] args) {
		String[] sl = { "One", "Two", "Three" };

		List<String> list = new ArrayList<String>(Arrays.asList(sl));

		System.out.println(list);
		
		List<List<String>> list1 = Collections.singletonList(list);
		System.out.println(list1);
		List<List<List<String>>> list2 = Collections.singletonList(list1);
		System.out.println(list2);
		
	}
}

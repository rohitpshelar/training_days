package sort_map_by_name_and_date;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Test {

	private static List<Pat> generateList() {
		List<Pat> l = new ArrayList<Pat>();
		l.add(new Pat("Rohit", Date.valueOf(LocalDate.of(2020, 12, 27)), new java.util.Date(2018-1902, 12, 27)));
		l.add(new Pat("Rohit", new Date(2018-1902, 12, 26), new java.util.Date(2018-1902, 12, 26)));
		l.add(new Pat("Don", new Date(2017-1902, 12, 17), new java.util.Date(2018-1902, 12, 17)));
		l.add(new Pat("Don", new Date(2017-1902, 12, 16), new java.util.Date(2018-1902, 12, 16)));
		l.add(new Pat("Rohit", new Date(2019-1902, 12, 28), new java.util.Date(2019-1902, 12, 28)));
		l.add(new Pat("Rohit", new Date(2019-1902, 12, 29), new java.util.Date(2019-1902, 12, 29)));
		l.add(new Pat("Don", new Date(2019-1902, 12, 28), new java.util.Date(2019-1902, 12, 28)));
		l.add(new Pat("Don", new Date(2019-1902, 12, 29), new java.util.Date(2019-1902, 12, 29)));		
		
		
		return l ;
	}
	
	
	private static Map<String, Pat> groupByNameandLatestDateJAVA(List<Pat> l) {
		Map<String, Pat> map = new LinkedHashMap<String, Pat>();

		for (Pat pat : l) {
			if (map.containsKey(pat.getName())) {
				if (map.get(pat.getName()).getExpDate().before(pat.getExpDate())) {
					map.put(pat.getName(), pat);
				} 
			}else {
				map.put(pat.getName(), pat);
			}
		}
		return map;
	}
	
	
	private static Map<String, Pat> groupByNameandLatestDateSQL(List<Pat> l) {
		Map<String, Pat> map = new LinkedHashMap<String, Pat>();

		for (Pat pat : l) {
			if (map.containsKey(pat.getName())) {
				if (map.get(pat.getName()).getBdd().before(pat.getBdd())) {
					map.put(pat.getName(), pat);
				} 
			}else {
				map.put(pat.getName(), pat);
			}
		}
		return map;
	}
	
	private static void displayMap(Map<String, Pat> m) {
	System.out.println(m);

	}
	
	public static void main(String[] args) {
		System.out.println("JAVA");
		displayMap(groupByNameandLatestDateJAVA(generateList()));
		
		System.out.println("\n SQL");
		displayMap(groupByNameandLatestDateSQL(generateList()));
		
		
		
		
	}
}

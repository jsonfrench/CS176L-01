//code from https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/

// Java program to sort hashmap by values
import java.util.*;
import java.lang.*;

public class MapSort {

	// function to sort hashmap by values
	public static HashMap<String, Float> sortByValue(HashMap<String, Float> hm)
	{
		// Create a list from elements of HashMap
		List<Map.Entry<String, Float> > list =
			new LinkedList<Map.Entry<String, Float> >(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Float> >() {
			public int compare(Map.Entry<String, Float> o1,
							Map.Entry<String, Float> o2)
			{
				return (o1.getValue()).compareTo(o2.getValue()) * -1; // <---- I am so smart i reversed the sort function by multiplying by -1
			}
		});
		
		// put data from sorted list to hashmap
		HashMap<String, Float> temp = new LinkedHashMap<String, Float>();
		for (Map.Entry<String, Float> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
}

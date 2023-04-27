import java.io.*;
import java.util.*;
import org.jsoup.*;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Fangraph_v2 {
	
	public static void main(String args[]) throws IOException {
		
		int num_row_elements = 19;
		String url_1 = "https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=";
		String url_2 = "&month=0&season1=";
		String url_3 = "&ind=0&team=0&rost=0&age=0&filter=&players=0&page=1_";
		int top_length = 50;
		int cutoff = 10;
		String name = ""; 
		float war = 0;
		
		MapSort sorter = new MapSort();
		
		HashMap<String, Float> top_players = new HashMap<String, Float>();

		
		for (int year = 2019; year < 2022; year++) {
			
			String url_year = url_1 + year + url_2 + year + url_3 + top_length;			//create url with custom year and length
	
			Document doc = Jsoup.connect(url_year).timeout(6000).get();		//connect to url
			Elements body = doc.select("tbody");							//select body		
			
			int element_num = 0;
			for (Element chart_row: body.select("td.grid_line_regular")) {
				element_num ++;
				String row_element = chart_row.select("td.grid_line_regular").text();
				
				if (element_num % num_row_elements == 2) {
					name = row_element;
				}
				else if (element_num % num_row_elements == 0) {
					war = Float.parseFloat(row_element);
				}
				if (name.length() > 0 && war > 0) {
					top_players.put(name, war);
				}
			}		
		}
		
		Map<String, Float> top_players_by_war = sorter.sortByValue(top_players);
		
		int c = 1;
		for(Map.Entry<String, Float> pair : top_players_by_war.entrySet()) {
			System.out.printf("%s: %s - %s%n", c, pair.getKey(), pair.getValue());
			c++;
			if (c > cutoff) {
				break;
			}
		}
	
	}
}
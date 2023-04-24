import java.io.*;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FangraphTopTen {
	
	public static void main(String args[]) throws IOException {
		
		final int TOP_NUM = 10;
		int year = 2020;
		
		ArrayList<String> twenty = new ArrayList();
		
		Document doc = Jsoup.connect("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2020&month=0&season1=2020&ind=0&team=0&rost=0&age=0&filter=&players=0")
				.timeout(6000).get();
		
		Elements body = doc.select("tbody");
		int counter = 0;
		
		for (Element e: body.select("td.grid_line_regular")) {
			String name = e.select("a").text();
			if (name != "" && name.length() > 3) {
				twenty.add(name);
				
			}
		}
		
		System.out.printf("%s:%n", year);
		for (int i = 0; i < TOP_NUM; i++) {
			System.out.printf("%s: %s%n", i+1, twenty.get(i));
		}
		System.out.printf("%n", null);		
		
		
		
		ArrayList<String> twentyone = new ArrayList();
		
		Document doc_one = Jsoup.connect("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2021&month=0&season1=2021&ind=0&team=0&rost=0&age=0&filter=&players=0")
				.timeout(6000).get();
		
		Elements body_one = doc_one.select("tbody");
		counter = 0;
		
		for (Element e: body_one.select("td.grid_line_regular")) {
			String name = e.select("a").text();
			if (name != "" && name.length() > 3) {
				twentyone.add(name);
				
			}
		}
		
		System.out.printf("%s:%n", year+1);
		for (int i = 0; i < TOP_NUM; i++) {
			System.out.printf("%s: %s%n", i+1, twentyone.get(i));
		}
		System.out.printf("%n", null);		
	
		
			
		ArrayList<String> twentytwo = new ArrayList();
		
		Document doc_two = Jsoup.connect("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2022&month=0&season1=2022&ind=0&team=0&rost=0&age=0&filter=&players=0")
				.timeout(6000).get();
		
		Elements body_two = doc_two.select("tbody");
		counter = 0;
		
		for (Element e: body_two.select("td.grid_line_regular")) {
			String name = e.select("a").text();
			if (name != "" && name.length() > 3) {
				twentytwo.add(name);
				
			}
		}
		
		System.out.printf("%s:%n", year+2);
		for (int i = 0; i < TOP_NUM; i++) {
			System.out.printf("%s: %s%n", i+1, twentytwo.get(i));
		}
		System.out.printf("%n", null);		
	
		
			
		
	}
}

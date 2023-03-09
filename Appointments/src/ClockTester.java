//French 3.9.23
//https://media.cheggcdn.com/media/5e0/5e065e25-34ab-4b28-9f62-c749a3ec910e/phpwMrBly.png

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  

public class ClockTester {

	public static void main(String[] args) {
		
		Clock clock = new Clock();
		
		int hours = clock.get_hours();
		int minutes = clock.get_minutes();
		String time = clock.get_time();

		clock.print_time();
		
		System.out.printf("%s%n", hours);
		System.out.printf("%s%n", minutes);
		System.out.printf("%s%n", time);
		
		
	}

}

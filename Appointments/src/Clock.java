import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  

public class Clock {

	//https://www.javatpoint.com/java-get-current-date
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");		
	LocalDateTime now = LocalDateTime.now();		
	
	private String time = dtf.format(now);
	
	public String get_time() {
		return String.format("%02d",get_hours()) + ":" + String.format("%02d",get_minutes());
	}

	public void print_time() {
		System.out.printf("%s%n", time);
	}

	public int get_hours() {		
		return Integer.parseInt(time.substring(11,13));
	}

	public int get_minutes() {
		return Integer.parseInt(time.substring(14,16));
	}

}

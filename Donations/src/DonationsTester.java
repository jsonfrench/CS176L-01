import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DonationsTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		File donations_txt = new File("Donations.txt");	//import .txt file
		Scanner donations_reader = new Scanner(donations_txt);
		
		Scanner input = new Scanner(System.in);			//import scanner
		Donations giveToMe = new Donations();			//import donations class
		
		System.out.print("Would you like to process donations now? (enter \'Yes\' to continue):");
		
		String user_response = input.nextLine();		//read input
		user_response = user_response.toLowerCase();
		boolean response_is_yes = user_response.equals("yes");
		
		if (!response_is_yes) {							//guard cause
			System.out.print("Ending now without processing donations\n");
			System.exit(0);
		}
		
		//read from file
		String line;
		while (donations_reader.hasNextLine()) {
		line = donations_reader.nextLine();

		String[] parsed_line = line.split(">");
		int donation_amount = Integer.parseInt(parsed_line[1]);

		System.out.println(parsed_line.length);
		
		if (parsed_line.length > 1) {
			System.out.println(donation_amount);
		}
		
		}

		giveToMe.getStatistics();

	}

}
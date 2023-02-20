import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

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
				
			if (parsed_line.length > 1) {
				String donation_category = parsed_line[0];
				donation_category = donation_category.substring(1);
				int donation_amount = Integer.parseInt(parsed_line[1]);
				giveToMe.processDonation(donation_category, donation_amount);
			}
				
		}

		giveToMe.getStatistics();

	}

}
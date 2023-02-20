import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class DonationsTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		/*==========create objects==========*/
		File donations_txt = new File("Donations.txt");			//.txt file
		Scanner donations_reader = new Scanner(donations_txt);	//.txt file reader
		Scanner input = new Scanner(System.in);					//user input 
		Donations giveToMe = new Donations();					//donations class

		/*==========read and process input==========*/
		System.out.print("Would you like to process donations now? (enter \'Yes\' to continue):\n");

		String user_response = input.nextLine();				
		user_response = user_response.toLowerCase();			
		boolean response_is_yes = user_response.equals("yes");

		/*==========interpret input==========*/
		if (!response_is_yes) {	
			System.out.print("Ending now without processing donations\n");
			System.exit(0);
		}
		
		/*==========read from file==========*/
		String line;
		while (donations_reader.hasNextLine()) {
			
			line = donations_reader.nextLine();					//read every line
			String[] parsed_line = line.split(">");				//and then split them by ">"
				
			if (parsed_line.length > 1) {										//if there is something after the ">" (excludes <EOF>)
				String donation_category = parsed_line[0];						
				donation_category = donation_category.substring(1);
				int donation_amount = Integer.parseInt(parsed_line[1]);
				giveToMe.processDonation(donation_category, donation_amount);
			}
				
		}

		/*==========execute function==========*/
		giveToMe.getStatistics();

	}

}
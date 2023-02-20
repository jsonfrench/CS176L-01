
public class Donations {
	
	private int numIndividual;
	private float amtIndividual;
	private int numBusiness;
	private float amtBusiness;
	private int numOther;
	private float amtOther;

	public void processDonation(String cat, double donation) {
		if (cat.equals("business donation")) {
			numBusiness += donation / Math.abs(donation);
			amtBusiness += donation;
		} else if (cat.equals("individual donation")) {
			numIndividual+= donation / Math.abs(donation);
			amtIndividual += donation;
		} else if (cat.equals("other donation")) {
			numOther += donation / Math.abs(donation);
			amtOther += donation;
		} else {
			;
		}
	}
	
	public void getStatistics() {

/*
		System.out.printf("Number of donations for business: %s%n", numBusiness);
		System.out.printf("Total donations for business: $%.2f%n", amtBusiness);
		System.out.printf("Number of donations for individual: %s%n", numIndividual);
		System.out.printf("Total donations for individual: $%.2f%n", amtIndividual);
		System.out.printf("Number of donations for other: %s%n", numOther);
		System.out.printf("Total donations for other: $%.2f%n", amtOther);
*/
		
		System.out.printf("Individual: #:%s $%.2f%n", numIndividual, amtIndividual);
		System.out.printf("Business: #:%s $%.2f%n", numBusiness, amtBusiness);
		System.out.printf("Other: #:%s $%.2f%n", numOther, amtOther);
		
	}

}
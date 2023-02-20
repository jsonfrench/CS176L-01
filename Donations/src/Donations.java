
public class Donations {
	
	private int numIndividual;
	private float amtIndividual;
	private int numBusiness;
	private float amtBusiness;
	private int numOther;
	private float amtOther;

	public void processDonation(String cat, double donation) {
		;
	}
	
	public void getStatistics() {
		System.out.print("Number of donations for individual: " + numIndividual + "\n");
		System.out.print("Total donations for individual: " + amtIndividual + "\n");
		System.out.print("Number of donations for business: " + numBusiness + "\n");
		System.out.print("Total donations for business: " + amtBusiness + "\n");
		System.out.print("Number of donations for other: " + numOther + "\n");
		System.out.print("Total donations for other: " + amtOther + "\n");
	}

}
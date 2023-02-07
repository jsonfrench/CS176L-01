
public class Microwave {
	
	private int time;
	private int power = 1;
	
	//==========Time==========//
	public int getTime() {
		return time;
	}
	
	public void time() {
		time+=30;
		System.out.print("Time button was pressed. Time is " + time + " seconds.\n");
	}
	
	//==========Power==========//
	public int getPower() {
		return power;
	}
	
	public void power() {
		if (power == 1) {
			power = 2;
		}
		else {
			power = 1;
		}
		System.out.print("Power button was pressed. Power level is at " + power + ".\n");
	}

	//==========Reset==========//
	public void reset() {
		power = 1;
		time = 0;
		System.out.print("Reset button was pressed. Power level is " + power + ". Time is " + time + " seconds.\n");
	}

	//==========Start==========//
	public void start() {
		System.out.print("Cooking for " + time + " seconds at level " + power + ".\n");
	}

}

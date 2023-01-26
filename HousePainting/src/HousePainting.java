import java.util.Scanner;

public class HousePainting 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
				
		//declare variables
		float paint_cost;
		int house_length;
		int house_width;
		int house_height;
		int num_windows;
		int window_length;
		int window_width;
		int num_doors;
		int door_length;
		int door_width;
		
		double  peak_side;
		double normal_side;
		double total_window_area;
		double total_door_area;
		double total_house_area;
		double paintable_area;
		double total_cost;
		
		//take input for all of these godforsaken variables
		System.out.print("Please enter the cost per square foot: ");
		paint_cost = input.nextFloat();
		System.out.print("Please enter the length of the house: ");
		house_length = input.nextInt();
		System.out.print("Please enter the width of the house: ");
		house_width = input.nextInt();
		System.out.print("Please enter the heightof the house: ");
		house_height = input.nextInt();
		System.out.print("Please enter the number of windows: ");
		num_windows= input.nextInt();
		System.out.print("Please enter the length of a window: ");
		window_length= input.nextInt();
		System.out.print("Please enter the width of a window: ");
		window_width= input.nextInt();
		System.out.print("Please enter the number of doors: ");
		num_doors = input.nextInt();
		System.out.print("Please enter the length of a door: ");
		door_length= input.nextInt();
		System.out.print("Please enter the width of a door: ");
		door_width= input.nextInt();		
		
		//do the math
		peak_side = (house_length * house_width) + 0.5 * (house_length * (house_height - house_width));
		normal_side = house_length * house_width;
		total_window_area = num_windows * window_width * window_length;
		total_door_area = num_doors * door_width * door_length;
		total_house_area = 2 * (peak_side) + 2 * (normal_side);
		paintable_area = total_house_area - (total_door_area + total_window_area);
		total_cost = paintable_area * paint_cost;
		
		//output results of the calculations
		System.out.print("Your total paintable surface is " + (int)paintable_area + " square feet.\n");
		System.out.print("Your estimate is " + (int)total_cost + " dollars.\n");	
		
	}

}

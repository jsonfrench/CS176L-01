/**
   An instructor is represented by a name, a birth year, and a salary.
   You must enter the class name, instance variable(s), and constructor below
*/

public class Instructor extends Person{
	
	private float salary;
 
	/**
      Returns the string represention of the object.
      @return a string representation of the object
   */

	public Instructor(String name, int birthYear, float salary) {
		super(name, birthYear);
		this.salary = salary;
	}

   public String toString()
   {
      return "Instructor[super=" + super.toString() + ",salary=" + salary + "]";
   }
}
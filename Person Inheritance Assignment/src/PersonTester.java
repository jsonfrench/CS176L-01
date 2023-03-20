/**
 * Implement a superclass Person. 
 * Make two classes, Student and Instructor, that inherit from Person. 
 * A person has a name and a year of birth.
 * A student has a major, and an instructor has a salary.
 * Write the class declarations and the constructors for all classes
 * 
 * This class tests the Person, Student, and Instructor classes.
*/
public class PersonTester
{
   public static void main(String[] args)
   {
      /**
       * p1 is a Person "John" born in 1965
       * p2 is a Person "Mary Ann" born in 1970
       * s1 is a Student "Ann" born in 1982 and is a "Computer Science" major
       * s2 is a Student "Thomas" born in 1986 and is a "Biology" major
       * i1 is an Instructor "Joseph" born in 1954 earning 65000
       * Enter lines of code below to instantiate these objects:
       */
	   
	   Person John = new Person("John", 1965);
	   Person Mary_Ann = new Person("Mary Ann", 1970);
	   Student Ann = new Student("Ann", 1982, "Computer Science");
	   Student Thomas = new Student("Thomas", 1986, "Biology");
	   Instructor Joseph = new Instructor("Joseph", 1954, 65000);

      /**
       * Leave the following lines 'as is' to verify that your results match the expected results
       */
      System.out.println(John.toString());
      System.out.println("Expected: Person[name=John,birthYear=1965]");
      System.out.println("");
      
      System.out.println(Mary_Ann.toString());
      System.out.println("Expected: Person[name=Mary Ann,birthYear=1970]");
      System.out.println("");
      
      System.out.println(Ann.toString());
      System.out.println("Expected: Student[super=Person[name=Ann,birthYear=1982],major=Computer Science]");
      System.out.println("");
      
      System.out.println(Thomas.toString());
      System.out.println("Expected: Student[super=Person[name=Thomas,birthYear=1986],major=Biology]");
      System.out.println("");
      
      System.out.println(Joseph.toString());
      System.out.println("Expected: Instructor[super=Person[name=Joseph,birthYear=1954],salary=65000.0]");
   }
}

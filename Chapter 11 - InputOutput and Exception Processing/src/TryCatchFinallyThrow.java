import java.io.*;

class Example_Throw 
{ 
    //declare exception using throws in the method signature
  void testMethod(int num) throws IOException, ArithmeticException{ 
     if(num==1)
        throw new IOException("IOException Occurred");
     else if(num==2)
    	throw new ArithmeticException("ArithmeticException");
     
  } 
}

class Main{ 
  public static void main(String args[]){ 
   try
   { 
       //this try block calls the above method so handle the exception
     Example_Throw obj=new Example_Throw(); 
     obj.testMethod(0); //no error
     obj.testMethod(1); //IO Error
     obj.testMethod(2); //Arithmetic error
   }

   catch(ArithmeticException ex) //specific exception catch
   {
	   System.out.println(ex);
   }
   
   catch(Exception ex) //general exception catch
   {
     System.out.println(ex);
   }
   
      
   
   finally //optional
   {
	   System.out.println ("Finally block");
	   
   }
   
   
   System.out.println("Rest of the code");
  }
}
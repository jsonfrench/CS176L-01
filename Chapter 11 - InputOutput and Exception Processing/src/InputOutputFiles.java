import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
Used to test the BlankLinesRemover class.
*/
public class InputOutputFiles
{
public static void main(String[] args) throws FileNotFoundException
{
Scanner inputScanner = new Scanner(System.in);
File inputFile;
PrintWriter outputFile;


  while (true) {
     System.out.print("Please enter the path to open the input file for example C:\\\\Downloads\\\\lines.txt : ");
     String filePath = inputScanner.nextLine();
     inputFile = new File(filePath);
     try {
        Scanner in = new Scanner(inputFile);
        outputFile = new PrintWriter("outlines.txt");
        while (in.hasNext()) 
        {
           String what =in.nextLine();
           if(!what.equals("")) {
        	   outputFile.println(what);
        	   System.out.println(what);
           }
        }
        in.close();
        outputFile.close();
        break; // stop asking for file path
     } catch (FileNotFoundException e) {
        System.out.println("File is not found, please try again");
     }
  }
}
}
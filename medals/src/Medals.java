import java.util.ArrayList;

public class Medals {

  public static void main(String[] args) {

    //create 2d array to store medal data
    int[][] medalsArray = {
        { 0, 3, 0 }, // Canada
        { 0, 0, 1 }, // Italy
        { 0, 0, 1 }, // Germany
        { 1, 0, 0 }, // Japan
        { 0, 0, 1 }, // Kazakhstan
        { 3, 1, 1 }, // Russia
        { 0, 1, 0 }, // South Korea
        { 1, 0, 1 }, // United States
    };

    //create an array of countries' names to disply on the grid
    String[] countriesArray = {
      "Canada\t\t",
      "Italy\t\t", 
      "Germany\t\t", 
      "Japan\t\t", 
      "Kazakhstan\t", 
      "Russia\t\t", 
      "South Korea\t", 
      "United States\t", 
    };

    String title = "Country\t\t\tGold\t\tSilver\t\tBronze\t\tTotal"; 

    //create arraylists for every country
    ArrayList<Integer> canadaList = new ArrayList();
    ArrayList<Integer> italyList = new ArrayList();
    ArrayList<Integer> germanyList = new ArrayList();
    ArrayList<Integer> japanList = new ArrayList();
    ArrayList<Integer> kazakhstanList = new ArrayList();
    ArrayList<Integer> russiaList = new ArrayList();
    ArrayList<Integer> southKoreaList = new ArrayList();
    ArrayList<Integer> unitedStatesList = new ArrayList();

    //create arraylist of all countries, add each country to the list
    ArrayList<ArrayList<Integer>> countriesList = new ArrayList();
    countriesList.add(canadaList);
    countriesList.add(italyList);
    countriesList.add(germanyList);
    countriesList.add(japanList);
    countriesList.add(kazakhstanList);
    countriesList.add(russiaList);
    countriesList.add(southKoreaList);
    countriesList.add(unitedStatesList);

    //populate arraylist with elements in 2d array
    for (int i = 0; i < countriesList.size(); i++) {
      for (int j = 0; j < medalsArray[i].length; j++) {
        countriesList.get(i).add(medalsArray[i][j]);
      }
    }
    
    //print out medals
    System.out.print(title + "\n");
    for (int i = 0; i < countriesList.size(); i++) {
      System.out.print(countriesArray[i] + "\t");
      int total = 0;
      for(int j = 0; j < countriesList.get(i).size(); j++)  {
        System.out.print(countriesList.get(i).get(j) + "\t\t");
        total += countriesList.get(i).get(j);
      }
      System.out.print(total);
      System.out.println();
    }

    //print out total medals
    int sum = 0;
    System.out.print("Totals\t\t\t");
    for(int i = 0; i < countriesList.get(i).size(); i++) {
      int total = 0;
      for(int j = 0; j < countriesList.size(); j++) {
        total += countriesList.get(j).get(i);
      }
      System.out.print(total + "\t\t");
      sum += total; 
    }
    System.out.print(sum + "\n");
    

  }

}

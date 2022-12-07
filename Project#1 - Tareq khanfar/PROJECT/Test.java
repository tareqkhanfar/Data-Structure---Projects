package PROJECT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
// TODO Auto-generated method stub
LinkedList list = new LinkedList() ;

Scanner in = new Scanner (new File ("Flights.txt")) ;

  while (in.hasNextLine()) {
	  String str [] = in.nextLine().split(",") ;
  list.addFlight(new Flight(Integer.parseInt(str[0]) , str[1] , str[2] , str[3], Integer.parseInt(str[4])));
  
  }
 //list.DisplayFlight();

////////////////////////
  in = new Scanner (new File ("passangers.txt")) ;
 while (in.hasNextLine()) {
	  String str [] = in.nextLine().split(",") ;
 //list.addPassangers(Integer.parseInt(str[0]), new Passanger(Integer.parseInt(str[0]) ,Integer.parseInt(str[1]) ,str[2] , str[3] , str[4] , str[5] ));
 
 }
 list.DisplayAllPassanger();


}
	

}

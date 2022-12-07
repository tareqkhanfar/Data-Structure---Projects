package PROJECT;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import application.MessageError;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LinkedList {
Node first , last ; 
int maxTicketNumber ; // contain max ticket number  to add one on it , to use when reserve new passanger
private int size ; // contain number of passanger in this node
	public LinkedList() {
	}
	
	public Object getFirst () {
    if (size == 0 ) {
    	return null ;
    }
    return first.getValue() ;
	}
	
	public Object getLast () {
		if (size == 0 ) {
			return null ;
		}
		return last.getValue() ;
	}
	
	
	public void addFirst (Flight x) {
		
		if (size == 0) {
			
			 last =  first = new Node (x) ;
			
			
		}
		else {
			Node temp = new Node (x) ;
			temp.NextAddress = first ; 
			first = temp ;
		}
		size ++ ;
	}
	public void addLast (Flight x ) {
		if (size == 0 ) {
		
			first = last = new Node (x) ;
		}
		else {
			last.NextAddress = new Node (x) ;
			last = last.NextAddress ;
		}
		this.size++ ;

	}

public boolean removeFirst () {
	if (size == 0 ) {
		return false ;
	}
	else if (size == 1) {
		first = last = null ;
		return true ;
	}
	else {
		first = first.NextAddress ;
	}
	size-- ;
	return true ;
}

public boolean removeLast () {
	if (size == 0) {
		return false ;
	}
	else if (size == 1 ) {
		first = last = null ;
	}
	else {
		Node current = first ;
		for (int i = 0 ; i < size -2 ; i++) {
			current = current.NextAddress ;
		}
		current.NextAddress = null ;
		last = current ;
	}
	size -- ;
	return true  ;
}

public boolean remove (int index ) {
	if (index == 0 ) {
		removeFirst() ;
		return true ;
	}
	else if (index == size -1 ) {
		removeLast()  ;
		return true ;
	}
	else if (index >= size ) {
		return false ;
	}
	else {
		Node current = first ; 

for (int i = 0 ; i < index -1  ; i++) {
			current = current.NextAddress  ;
		}
		current.NextAddress = current.NextAddress.NextAddress ;
		size -- ;
		return true ;
	}
}
public void clear () {
	first = last = null ;
	size = 0 ;
}
public Node search ( int x ) { // this method can be send a flight number and return Node for this flight
	Node temp = first ;
	for (int i = 0  ; i < size ; i++) {
		if (((Flight)temp.getValue()).getFlightNumber() == x) {
			return temp ;
		}
		temp = temp .NextAddress ;
	}
	return null; 
}
public boolean contain (Object x ) {
	Node temp = first ;
	for (int i = 0  ; i < size ; i++) {
		if (x.equals(temp.getValue())) {
			return true ;
		}
		temp = temp .NextAddress ;
	}
	return false; 
}

public int getSize() {
	return size ;
}

///////////////////////////////////////////////////////////////



public void addFlight ( Flight x ) { 
	// here to add new Flight from user or file , and each element It will be put in the right place 
	// after finished the list  be  sorted by id Flight
	if (first == null ) { // if list is not exist any element , add new flight in first place
    	this.addFirst(x);
    }
	// if id for new flight less then or equal first flight , put new flight in first
    else if (((Flight)x).getFlightNumber() <= ((Flight)first.value).getFlightNumber() ) {
    		this.addFirst(x);
    	}
	// if id for new flight larger then or equal last flight , put new flight in last

    else if (((Flight)x).getFlightNumber() >= ((Flight)last.value).getFlightNumber() ) {

    		this.addLast(x);
    	
    	 }
    	else {
    		// if id for new flight not less than or equal first flight and last flight 

    		Node temp = new Node (x) ;
    		Node current = first.NextAddress;
    		Node prev = first;
    		while (true) {
    			if (((Flight)x).getFlightNumber() <= ((Flight)current.value).getFlightNumber() ) {
    				temp.NextAddress = current ;
    				prev.NextAddress = temp ;
    				size ++;
    				return ;
    			}
    			current = current.NextAddress ;
              if (current == null) {
               	return ;
                  }
    			prev = prev.NextAddress ;
    			
    		}
    	}
}



public int IndexOf (int idFlight) {
	Node temp = first ;
	for (int i = 0 ; i < size  ; i++) {
          if (((Flight)temp.value).getFlightNumber() == idFlight) {
        	  System.out.println(i);
        	  return i ;
          }
          temp = temp.NextAddress ;
	}
	
	return -1 ;
}

public String  DisplayFlight() {
	// this method to obtain all informaion about all flight in the system
	// return by String 
	String s = "" ;
	Node n = first ;
	for (int i = 0; i < size ; i++) {
		s += n.value.toString() + "\n";
		n = n.NextAddress; // move next flight
	}
	return s ;
}



public String DisplayAllPassanger () {
	// this method to obtain all informaion about all passangers in the all flight in system
		// return by String 
	Node current = first  ;
	String s = "" ;
	for (int i = 0 ; i < size ; i++) {
		NodeP temp = current.firstElement ;
		for (int j = 0 ; j < current.size ; j++) {
            s += temp.value.toString()+"\n";

temp = temp.NextElement2D ; // move next passanger
		}
		current = current.NextAddress ;// move next flight
	}
	return s ;
}


public int maxTicketNumber (int n) {
	// each passanger will added , take the ticket number and compareto another prevois value , if was large then put maximum value in maxTicketNumber
	// aim : to give new passanger maximum ticket number plus one
	
     if (n > maxTicketNumber ) 
    	 maxTicketNumber = n ;
	     return maxTicketNumber ;
}
public String searchPassanger(String s) {
	// recive name of passanger and search it in all flight , if exist then store in variable
	// aim : to obtain all passanger that have the same name
	String str = "" ;
	Node n = first ;
	for (int i = 0 ; i< size ; i++) {
		NodeP m = n.firstElement ;
		for (int j = 0 ; j < n.size ; j++) {
			if (((Passanger)m.value).getFullName().equals(s)){
				str += m.value.toString() + "\n" ;
			}
			m = m.NextElement2D;
		}
		n = n.NextAddress ;
	}
	return str ;
}
public  void checkIdFlight (int x) {
	// to check if new id number for new flight if exist already or not , if exist then send Exception , to handle in adding page
	
	 Node n= first ;
	 while(n != null ) {
		 if (n.value.getFlightNumber() == x) {
			 throw new IllegalArgumentException() ;
		 }
		 n = n.NextAddress ;
	 }
}

public  void checkPassanger (Node n , String x) {
	// this method recive flight and passport number
	// to check if new passport  number for new passanger if  already exist on this flight or not , if exist then send Exception , to handle in adding page
	NodeP y = n.firstElement ;
	 while(y != null ) {
		 if (y.value.getPassportNumber() .equals(x)) {
			 throw new IllegalArgumentException() ;
		 }
		 y = y.NextElement2D ;
	 }
}

public void reportFlight () {
	// to print all flight information in file 
	FileChooser f= new FileChooser() ;
	  f.setTitle("Select Location File");
File file = f.showOpenDialog(new Stage());

try {
	FileWriter out = new FileWriter(file , true) ;
	out.write(DisplayFlight());
	MessageError.MessageSaveData();
	out.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public void reportPassanger () {
	// to print all passenger information in file 

	FileChooser f= new FileChooser() ;
	  f.setTitle("Select Location File");
File file = f.showOpenDialog(new Stage());

try {
	FileWriter out = new FileWriter(file , true) ;
	out.write(DisplayAllPassanger());
	MessageError.MessageSaveData();

	out.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public void saveToFileFlight () {
	// to save passanger data  in file , even  reading in onother time
	FileChooser f= new FileChooser() ;
	  f.setTitle("Select Location File");
File file = f.showOpenDialog(new Stage());

try {
	FileWriter out = new FileWriter(file , true) ;
	Node n = first ;
    for (int i = 0 ; i < size ;i++) {
         out.write(n.value.FormatData() +"\n"); 
         n =n.NextAddress ;
    }
    out.close();
	MessageError.MessageSaveData();

} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public boolean removeFlight (int x ) {
	
	// this function to receve id flight and search it in list if exist remove it and return true , else return false
	Node temp = first.NextAddress ;
	Node prev = first;

	if (size == 0) {
		return false ;
		
	}
	else if (first.value.getFlightNumber() == x) {
     removeFirst() ;
     MessageError.MessageDeletePassanger();
   
    this.size -- ;
    MessageError.MessageDeletePassanger();
		return true ;
	}
	else if (last.value.getFlightNumber() == x) {
         removeLast() ;
         MessageError.MessageDeletePassanger();
         this.size -- ;

			return true ;


	}
	else {
		

		for (int i = 0 ; i  < this.size ; i++) {
        	 if (temp.value.getFlightNumber() == x) {
				prev.NextAddress = prev.NextAddress.NextAddress ;
		         MessageError.MessageDeletePassanger();
		       
		         this.size -- ;

				return true ;
			}
			temp = temp.NextAddress ;
			prev = prev.NextAddress ;
		}
         MessageError.MessageNotExistPassanger();

		return false ;

	}
}
public void saveToFilePassanger () {
	// to save passanger data  in file , even  reading in onother time
	FileChooser f= new FileChooser() ;
	  f.setTitle("Select Location File");
File file = f.showOpenDialog(new Stage());

try {
	FileWriter out = new FileWriter(file , true) ;
	Node n = first ;
    for (int i = 0 ; i < size ;i++) {
    	NodeP m = n.firstElement ;
    	for (int j = 0 ; j < n.getSize() ; j++) {
            out.write(m.value.FormatData()+"\n"); 	
             m = m.NextElement2D ;
    	}
    	n = n.NextAddress ;
    }
    out.close();
	MessageError.MessageSaveData();

} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

}



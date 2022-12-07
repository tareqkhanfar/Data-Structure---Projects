package PROJECT;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import application.MessageError;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Flight {
private int flightNumber ;
private String airlineName ;
private String source ;
private String dest ;
private int capacity ;
private int numberOfReservation ;
private int remainderReservation ;
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	public Flight(int flightNumber, String airlineName, String source, String dest, int capacity) {
		super();
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.source = source;
		this.dest = dest;
		this.capacity = capacity;
		this.remainderReservation = capacity ;
	}
	public String FormatData () {
		
		return this.getFlightNumber()+"," +this.getAirlineName()+"," + this.getSource() +"," + this.getDest() + "," + this.capacity+",";
		
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		
		setRemainderReservation(capacity);

		this.capacity = capacity;
	}
	@Override
	public String toString() {
		String str = "" ;
		str += "\n Flight Number : " + this.getFlightNumber();
		str += "\n AirLine Name  : %d "+ this.getAirlineName();
		str +="\n Source :" + this.getSource();
		str +="\n Destination  :" + this.getDest();
		str +="\n Capacity  :" + this.getCapacity();
		str +="\n Number Of Reservation  :" + this.getNumberOfReservation();
		str +="\n Number of seats left  :" + this.getRemainderReservation();

		str += "\n############################################################################\n";
		return str;
	}
	public int getNumberOfReservation() {
		return numberOfReservation;
	}
	public void setNumberOfReservation(int numberOfReservation) {
		this.numberOfReservation = numberOfReservation ;
	}
	public int getRemainderReservation() {
		return remainderReservation;
	}
	public void setRemainderReservation(int remainderReservation) {
		this.remainderReservation = remainderReservation;
	}
	
	

}

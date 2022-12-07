package PROJECT;

import java.util.Date;

public class Passanger {
private int flightNumber ;
private int ticketNumber;
private String fullName;
private String passportNumber ;
private String Nationality ;
private Date DOB ;
	public Passanger() {
		// TODO Auto-generated constructor stub
	}

	public Passanger(int flightNumber, int ticketNumber, String fullName, String passportNumber, String nationality,
			Date dOB) {
		super();
		this.flightNumber = flightNumber;
		this.ticketNumber = ticketNumber;
		this.fullName = fullName;
		this.passportNumber = passportNumber;
		Nationality = nationality;
		DOB = dOB;
		
	}
	public String FormatData() {
		return this.getFlightNumber() + "," + this.getTicketNumber() +"," + this.getFullName() + "," + this.getPassportNumber() + "," + this.getNationality() + "," + + DOB.getDate() + "/" + (DOB.getMonth()  +1  )+ "/" + (1900+DOB.getYear()+",");
		
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = (Date)dOB.clone();
	}

	@Override
	public String toString() {
		
		String str = "" ;
		str += "\n Flight Number : " + this.getFlightNumber();
		str += "\n Passanger Passport Number  : " +this.getPassportNumber();
		str +="\n Passanger Name :" + this.getFullName();
		str +="\n Ticket Number  :" + this.getTicketNumber();
		str +="\n Nationality  :" + this.getNationality();
		str +="\n Data Of Birth  :" + DOB.getDate() + "/" + (DOB.getMonth()  +1  )+ "/" + (1900+DOB.getYear()) ;

		str += "\n############################################################################\n";
		return str;
		
	}
	

}

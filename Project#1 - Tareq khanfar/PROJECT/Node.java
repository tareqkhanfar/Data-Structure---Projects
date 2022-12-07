package PROJECT;

import application.MessageError;

public class Node {
	 Flight value ; 
	Node NextAddress ;
	public NodeP firstElement ;
	public NodeP lastElement ;
	 public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	int size ;
	public Node() {
		
	}
	public Node(Flight o) {
		this.setValue(o) ;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Flight value) {
		this.value = value;
	}
	
	public Object getFirst () {
	    if (size == 0 ) {
	    	return null ;
	    }
	    return firstElement.value ;
		}
		
		public Object getLast () {
			if (size == 0 ) {
				return null ;
			}
			return lastElement.value ;
		}
		
		public void addFirst (Passanger x) {
			
			if (size == 0) {
				
				 firstElement = lastElement = new NodeP (x) ;
				
				
			}
			else {
				NodeP temp = new NodeP (x) ;
				temp.NextElement2D = firstElement ; 
				firstElement = temp ;
			}
			size ++ ;
		}
		public void addLast (Passanger x ) {
			if (size == 0 ) {
			
				firstElement = lastElement = new NodeP (x) ;
			}
			else {
				lastElement.NextElement2D = new NodeP (x) ;
				lastElement = lastElement.NextElement2D ;
			}
			this.size++ ;

		}

	public boolean removeFirst () {
		if (size == 0 ) {
			return false ;
		}
		else if (size == 1) {
			firstElement = lastElement = null ;
			return true ;
		}
		else {
			firstElement = firstElement.NextElement2D ;
		}
		size-- ;
		return true ;
	}

	public boolean removeLast () {
		if (size == 0) {
			return false ;
		}
		else if (size == 1 ) {
			firstElement = lastElement = null ;
		}
		else {
			NodeP current = firstElement ;
			for (int i = 0 ; i < size -2 ; i++) {
				current = current.NextElement2D ;
			}
			current.NextElement2D = null ;
			lastElement = current ;
		}
		size -- ;
		return true  ;
	}
	public  boolean addPassangers (Passanger x ) {
		if (this.value.getRemainderReservation() > 0 ) {
		this.value.setRemainderReservation(this.value.getRemainderReservation() - 1 );
		((Flight)this.value).setNumberOfReservation(((Flight)this.value).getNumberOfReservation()+1);
		if (this != null )
			if (firstElement == null ) {

		    	this.addFirst(x);
		    	return true ;
		    }
		    else if  (((Passanger)x).getFullName().compareTo(((Passanger)firstElement.value).getFullName()) <= 0) {

		    		this.addFirst(x);
		    		return true ;
		    	}
		    	else if (((Passanger)x).getFullName().compareTo(((Passanger)lastElement.value).getFullName()) >= 0) {


		    		this.addLast(x);
		    		return true ;
		    	
		    	 }
		    	else {
		    		
		    		NodeP temp = new NodeP (x) ;
		    		NodeP current = firstElement.NextElement2D;
		    		NodeP prev = firstElement;
		    		while (true) {
		    			 if  (((Passanger)x).getFullName().compareTo(((Passanger)current.value).getFullName()) <= 0) {
		    				temp.NextElement2D = current ;
		    				prev.NextElement2D = temp ;
		    				 size ++;

		    				return true;
		    			}
		    			current = current.NextElement2D ;
		              if (current == null) {
		               	return false ;
		                  }
		    			prev = prev.NextElement2D ;
		    			
		    		}
		    	}
		}
		
			MessageError.EmptyCapacity(this.value.getFlightNumber(),this.value.getAirlineName());
			return false ;

		
		}
	
	public String getSpecificPassanger() {
		NodeP temp = this.firstElement ;
		String str = "" ;
		for (int i = 0 ; i < this.getSize() ; i++) {
			str += temp.value.toString() + "\n" ;
			temp = temp .NextElement2D ;
		}
		return str;
		
	}
	public boolean remove (String x ) {
		
		NodeP temp = firstElement.NextElement2D;
		NodeP prev = firstElement;
	
		if (size == 0) {
			return false ;
			
		}
		else if (((Passanger)firstElement.value).getFullName().equals(x)) {
         removeFirst() ;
         MessageError.MessageDeletePassanger();
         this.value.setNumberOfReservation(this.value.getNumberOfReservation()-1);
         this.value.setRemainderReservation(  this.value.getRemainderReservation() + 1);
        this.size -- ;
        MessageError.MessageDeletePassanger();
			return true ;
		}
		else if (((Passanger)firstElement.value).getFullName().equals(x)) {
	         removeLast() ;
	         MessageError.MessageDeletePassanger();
	         this.value.setNumberOfReservation(this.value.getNumberOfReservation()-1);
	         this.value.setRemainderReservation(  this.value.getRemainderReservation() + 1);
	         this.size -- ;
	         MessageError.MessageDeletePassanger();

				return true ;


		}
		else {
			

			for (int i = 0 ; i  < this.size ; i++) {
            	 if (((Passanger)temp.value).getFullName().equals(x)) {
					prev.NextElement2D = prev.NextElement2D.NextElement2D ;
			         MessageError.MessageDeletePassanger();
			         this.value.setNumberOfReservation(this.value.getNumberOfReservation()-1);
			         this.value.setRemainderReservation(  this.value.getRemainderReservation() + 1);
			         this.size -- ;
			         MessageError.MessageDeletePassanger();

					return true ;
				}
				temp = temp.NextElement2D ;
				prev = prev.NextElement2D ;
			}
	         MessageError.MessageNotExistPassanger();

			return false ;

		}
		
	}
	public boolean checkTicket (String x ) {
		// recive name of passanger to chech has a ticket or no exist 
		// aim : to know a specific 
		NodeP temp = firstElement;	
		if (size == 0) {
			MessageError.TickitNotExist();

			return false ;
		}
		else if (((Passanger)firstElement.value).getFullName().equals(x)) {
			MessageError.TickitExist();
			return true ;
		}
		else if (((Passanger)lastElement.value).getFullName().equals(x)) {
			MessageError.TickitExist();

				return true ;
		}
		else {
			for (int i = 0 ; i  < this.size ; i++) {
            	 if (((Passanger)temp.value).getFullName().equals(x)) {
         			MessageError.TickitExist();

            		 
					return true ;
				}
				temp = temp.NextElement2D ;
			}
			MessageError.TickitNotExist();

			return false ;

		}
		
	}
	public NodeP search (String str) {
		// this method recive passport number of passanger in one flight and return passenger(Node);
		NodeP n = this.firstElement ;
		for (int i = 0 ; i < this.getSize() ; i++) {
			if (n.value.getPassportNumber().equals(str)) {
				return n ;
			}
			n = n.NextElement2D ;
		}
		return null ;
	}
	

}

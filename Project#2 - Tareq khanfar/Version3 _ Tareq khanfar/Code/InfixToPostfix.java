package Code;


public class InfixToPostfix {

	public InfixToPostfix() {
		// TODO Auto-generated constructor stub
	}

		// TODO Auto-generated method stub
		/*
		 * String infix =
		 * "(30.6*(35.444*3/8.9)*(1+4+1*(3-1)+1+1)-(((4+1.5553-2)/4.913+2)))"; infix =
		 * "3+5*(3+2)"; System.out.println(format(infix)); String[] after =
		 * toArrayString(format(infix)) ; String post = infixToPostfix(after) ;
		 * System.out.println(post); System.out.println("\n"+post.equals("3491-*9*+"));
		 * System.out.println(evaluation(post.split("#"))); // 25+54+4*83+-*31/874*+-/
		 */	
	
	public static String infixToPostfix (String e[] ) {
		
		   int stack = CursorStack.alloc();
          StringBuilder output = new StringBuilder();
     System.out.println(e.length);
          for (int i = 0 ; i < e.length ; i++) {
        	 if (e[i] == "") {
        		 continue ;
        	 }
        	  if (isDigit (e[i])) {
        		  output.append(e[i]+",") ;
        	  }
        	  else if (e[i].equals("("))  {
        		  CursorStack.push(stack, e[i]) ;
        	  }
        	  else if (e[i].equals(")")) {
        		  while (!((String)CursorStack.getTop(stack)).equals("(")) {
        			  System.out.println((String)CursorStack.getTop(stack));
        			  output.append((String)CursorStack.getTop(stack)+",");
        			  CursorStack.pop(stack);
        		  }
    			  CursorStack.pop(stack);
 
        	  }
        	  else {
        		//  System.out.println("New : " + e[i].charAt(0) + "-----" + "top : " + ((String)CursorStack.getTop(stack)).charAt(0));
        		  while (!CursorStack.isEmpty(stack) && (MaxPriority(e[i].charAt(0), ((String)CursorStack.getTop(stack)).charAt(0)) == false)) {
             		 System.out.println(e[i] +"" + (CursorStack.getTop(stack)) +"   -->" + MaxPriority(e[i].charAt(0), ((String)CursorStack.getTop(stack)).charAt(0)));
            			 
            			  output.append(CursorStack.getTop(stack)+",");
            			  CursorStack.pop(stack);
            		  
        		  }
          	//	 System.out.println(e[i] +" " + (CursorStack.getTop(stack)) +"   -->" + MaxPriority(e[i].charAt(0), ((String)CursorStack.getTop(stack)).charAt(0)));

        		  CursorStack.push(stack, e[i]) ;

        		 //stack.push(e[i]) ;
        	  }
          }
          while (!CursorStack.isEmpty(stack)) {
			  output.append(CursorStack.getTop(stack)+",");
			  CursorStack.pop(stack);
          }
		return output.toString().replace(",,", ",") ;
	}
	static boolean MaxPriority (char New , char topStack ) {
		
		if ((New=='!') && (topStack == '/' || topStack == '*' ||topStack == '%' ||topStack == '+' ||topStack == '-' ||topStack == '^')) {
			return true ;
		}
		if ((New == '^') && (topStack == '/' || topStack == '*' ||topStack == '%' ||topStack == '+' ||topStack == '-' )) {
			return true ;
		}
		if ((New == '/' || New == '*' ||New == '%'  ) &&(topStack  == '/' || topStack == '*'||topStack == '%')) {
			return false  ;
		}
		else if ((New == '/' || New == '*' ||New == '%' ||New == '^' )&& (topStack  == '+' || topStack == '-' )) {
			return true  ;
		}else if ((New == '+' || New == '-' )&& (topStack  == '/' || topStack == '*' ||topStack == '%' ) ) {
			return false  ;
		}
		else if ((New == '+' || New == '-' || New  == '*' || New == '/' || New == '%' || New == '!' || New =='^') && topStack == '(') {

			return true ;
		}
		else {
			return false ;

		}
		
	}
	public static double evaluation (String s[] ) {
		int stack = CursorStack.alloc();
		for (int i = 0 ;i < s.length ; i++) {
			if (s[i]=="") {
				continue;
			}
			if (isDigit(s[i])) {
				CursorStack.push(stack, s[i]);
			}
			else {
				

			   switch (s[i].charAt(0)) {
			                               
			   case '+' : 	double second = Double.parseDouble(CursorStack.getTop(stack)+"");
				CursorStack.pop(stack);
			    double first = Double.parseDouble(CursorStack.getTop(stack)+"");	
				CursorStack.pop(stack);
				   CursorStack.push(stack,first + second);

			   break ;
			   case '-' :  second = Double.parseDouble(CursorStack.getTop(stack)+"");
				CursorStack.pop(stack);
			     first = Double.parseDouble(CursorStack.getTop(stack)+"");	
				CursorStack.pop(stack);
				   CursorStack.push(stack,first - second);
			   break ;
			   case '/' : 	 second = Double.parseDouble(CursorStack.getTop(stack)+"");
				CursorStack.pop(stack);
			     first = Double.parseDouble(CursorStack.getTop(stack)+"");	
				CursorStack.pop(stack);			CursorStack.push(stack,first / second);
			   break ;
			   case '*' : 	 second = Double.parseDouble(CursorStack.getTop(stack)+"");
				             CursorStack.pop(stack);
			                 first = Double.parseDouble(CursorStack.getTop(stack)+"");	
			                 CursorStack.pop(stack);			
			                 CursorStack.push(stack,first * second);
			   				break ;
			   case '%' : 	 second = Double.parseDouble(CursorStack.getTop(stack)+"");
				CursorStack.pop(stack);
			     first = Double.parseDouble(CursorStack.getTop(stack)+"");	
				CursorStack.pop(stack);			CursorStack.push(stack,first % second);
  				break ;
			   case '^' :  second = Double.parseDouble(CursorStack.getTop(stack)+"");
				CursorStack.pop(stack);
			     first = Double.parseDouble(CursorStack.getTop(stack)+"");	
				CursorStack.pop(stack);				CursorStack.push(stack,Math.pow(first, second));
 				break ;
			
			   case '!' : 	 second = Double.parseDouble(CursorStack.getTop(stack)+"");
				CursorStack.pop(stack);
						CursorStack.push(stack,fact((int)second));
				break ;
			   
				   }
			}
		}
		return Double.parseDouble(CursorStack.getTop(stack)+"") ;
	}
	public static String format(String s ) {
		String out = "" ;
		for (int i = 0 ; i < s.length() ; i++) {
          if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.') {
        	  out+= s.charAt(i);
          }
          else {
        	  out+= "," + s.charAt(i)+"," ;
          }
		}
		
		return out.replace(",,", ",");
	}
	public static String [] toArrayString (String s ) {
		System.out.println();
		String []a = s.split(",") ;
		System.out.println(a.length);
		for (int i = 0 ; i < a.length ; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
         
		return a ;
	}
static boolean isDigit (String s) {
	try {
		if (Double.parseDouble(s)>=0 ||Double.parseDouble(s)<=0 ) {
			return true ;
		}	
	}
	catch (Exception e) {
		return false ;

	}
	return false ;

	
}
static long fact (int n) {
	int fact = 1 ;
	for (int i = 1 ; i <=n ;i++) {
		fact *= i ;
	}
	return fact ;
}
public static boolean balanced (String s ) {
	int balanced = CursorStack.alloc() ;
	for (int i = 0 ; i < s.length() ; i++) {
		if (s.charAt(i) == '(') {
			CursorStack.push(balanced, s.charAt(i)) ;
		}
		else if (s.charAt(i) == ')') {
			if  (CursorStack.isEmpty(balanced) || (char)CursorStack.getTop(balanced) != '(') {
				return false; 
			}
			else {
				CursorStack.pop(balanced);
			}
		}
	}
	return CursorStack.isEmpty(balanced);
}

}

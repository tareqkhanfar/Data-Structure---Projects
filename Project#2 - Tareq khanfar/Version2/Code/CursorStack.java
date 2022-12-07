package Code;

public class CursorStack {
private final static int space = 200 ;
static Node [] cursorSpace = new Node [space] ;
	
	static {
for (int i = 0 ; i < space ; i++) {
	cursorSpace[i] = new Node (null , i+1) ;
}
cursorSpace[space-1].n = 0 ;
	}
	
	public static int alloc () {
		int p = cursorSpace[0].n ;
		cursorSpace[0].n = cursorSpace[p].n ;
		
		if (p==0) {
			throw new OutOfMemoryError() ;
		}
		cursorSpace[p].n = 0;
		return p ;
	}
	private static void free (int p ) {
		cursorSpace[p].value = null; 
		cursorSpace[p].n = cursorSpace[0].n ;
		cursorSpace[0].n = p ;
	}
	public static boolean isEmpty (int header) {
		return cursorSpace[header].n == 0 ;
	}
	public static void push (int header , Object x) {
		int temp = alloc() ;
		
		if (isEmpty(header)) {
			cursorSpace[header].n = temp ;
			cursorSpace[temp].value = x ;
		}
		else {
			cursorSpace[temp].n = cursorSpace[header].n ;
			cursorSpace[header].n = temp ;
			cursorSpace[temp].value = x ;
		}
	}
	public static Object getTop(int header) {
		if (isEmpty(header)) {
			return null ;
		}
		int top = cursorSpace[header].n  ;
		return cursorSpace[top].value ;
	}
	public static boolean pop (int header) {
		if (isEmpty(header)) {
			return false ;
		}
		int temp = cursorSpace[header].n ;
		cursorSpace[header].n = cursorSpace[temp].n ;
		free(temp);
		
		return true ;
	}
	public static void print (int header) {
		int temp = cursorSpace[header].n ;
		while (temp != 0) {
			System.out.println(cursorSpace[temp].value);
			temp = cursorSpace[temp].n ;
		}
	}

}

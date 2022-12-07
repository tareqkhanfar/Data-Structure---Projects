package Code;

public class MainTest {

	public MainTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
int stack = CursorStack.alloc() ;
CursorStack.push(stack, "A");
CursorStack.push(stack, "B");
CursorStack.push(stack, "C");
CursorStack.push(stack, "D");
CursorStack.push(stack, "D");
CursorStack.push(stack, "D");
CursorStack.push(stack, "D");
CursorStack.push(stack, "D");
CursorStack.print(stack);
System.out.println("######################################");
System.out.println(CursorStack.getTop(stack));
CursorStack.pop(stack);
CursorStack.pop(stack);
CursorStack.pop(stack);
CursorStack.pop(stack);
CursorStack.pop(stack);
CursorStack.pop(stack);

System.out.println(CursorStack.getTop(stack));

	}

}

package DataStrucutre;

public class Node {
	public Department element;
	int h; // for height
	Node left;
	Node right;

	// default constructor to create null node

	// parameterized constructor
	public Node(Department element) {
		left = null;
		right = null;
		this.element = element;
		h = 0;
	}
}
package DataStrucutre;

public class Node {
	public Department element;
	int h; // for height
	Node leftChild;
	Node rightChild;

	// default constructor to create null node

	// parameterized constructor
	public Node(Department element) {
		leftChild = null;
		rightChild = null;
		this.element = element;
		h = 0;
	}
}
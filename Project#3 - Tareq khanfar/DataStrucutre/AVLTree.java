package DataStrucutre;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.ComboBox;

public class AVLTree {
	private Node rootNode;

	// Constructor to set null value to the rootNode
	public AVLTree() {
		rootNode = null;
	}

	// create removeAll() method to make AVL Tree empty
	public void removeAll() {
		rootNode = null;
	}

	// create checkEmpty() method to check whether the AVL Tree is empty or not
	public boolean checkEmpty() {
		if (rootNode == null)
			return true;
		else
			return false;
	}

	// create insertElement() to insert element to to the AVL Tree
	public void insertElement(Department element) {
		rootNode = insertElement(element, rootNode);
	}

	public int getHeight() {
		return getHeight(rootNode);
	}

	// create getHeight() method to get the height of the AVL Tree
	private int getHeight(Node node) {
		return node == null ? -1 : node.h;
	}

	// create maxNode() method to get the maximum height from left and right node
	private int getMaxHeight(int leftNodeHeight, int rightNodeHeight) {
		return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
	}

	// create insertElement() method to insert data in the AVL Tree recursively
	private Node insertElement(Department element, Node node) {
		// check whether the node is null or not
		if (node == null)
			node = new Node(element);
		// insert a node in case when the given element is lesser than the element of
		// the root node
		else if (element.getDepName().compareTo(node.element.getDepName()) < 0) {
			node.leftChild = insertElement(element, node.leftChild);
			if (getHeight(node.leftChild) - getHeight(node.rightChild) == 2)
				if (element.getDepName().compareTo(node.leftChild.element.getDepName()) < 0)
					node = rotateWithLeftChild(node);
				else
					node = doubleWithLeftChild(node);
		} else if (element.getDepName().compareTo(node.element.getDepName()) > 0) {
			node.rightChild = insertElement(element, node.rightChild);
			if (getHeight(node.rightChild) - getHeight(node.leftChild) == 2)
				if (element.getDepName().compareTo(node.rightChild.element.getDepName()) > 0)
					node = rotateWithRightChild(node);
				else
					node = doubleWithRightChild(node);
		} else
			; // if the element is already present in the tree, we will do nothing
		node.h = getMaxHeight(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;

		return node;

	}

	// creating rotateWithLeftChild() method to perform rotation of binary tree node
	// with left child
	private Node rotateWithLeftChild(Node node2) {
		Node node1 = node2.leftChild;
		node2.leftChild = node1.rightChild;
		node1.rightChild = node2;
		node2.h = getMaxHeight(getHeight(node2.leftChild), getHeight(node2.rightChild)) + 1;
		node1.h = getMaxHeight(getHeight(node1.leftChild), node2.h) + 1;
		return node1;
	}

	// creating rotateWithRightChild() method to perform rotation of binary tree
	// node with right child
	private Node rotateWithRightChild(Node node1) {
		Node node2 = node1.rightChild;
		node1.rightChild = node2.leftChild;
		node2.leftChild = node1;
		node1.h = getMaxHeight(getHeight(node1.leftChild), getHeight(node1.rightChild)) + 1;
		node2.h = getMaxHeight(getHeight(node2.rightChild), node1.h) + 1;
		return node2;
	}

	// create doubleWithLeftChild() method to perform double rotation of binary tree
	// node. This method first rotate the left child with its right child, and after
	// that, node3 with the new left child
	private Node doubleWithLeftChild(Node node3) {
		node3.leftChild = rotateWithRightChild(node3.leftChild);
		return rotateWithLeftChild(node3);
	}

	// create doubleWithRightChild() method to perform double rotation of binary
	// tree node. This method first rotate the right child with its left child and
	// after that node1 with the new right child
	private Node doubleWithRightChild(Node node1) {
		node1.rightChild = rotateWithLeftChild(node1.rightChild);
		return rotateWithRightChild(node1);
	}

	// create getTotalNumberOfNodes() method to get total number of nodes in the AVL
	// Tree
	public int getTotalNumberOfNodes() {
		return getTotalNumberOfNodes(rootNode);
	}

	private int getTotalNumberOfNodes(Node head) {
		if (head == null)
			return 0;
		else {
			int length = 1;
			length = length + getTotalNumberOfNodes(head.leftChild);
			length = length + getTotalNumberOfNodes(head.rightChild);
			return length;
		}
	}

	// create searchElement() method to find an element in the AVL Tree
	public Node search(String x) {
		if (rootNode == null) {
			return null;
		} else {
			return search(rootNode, x);
		}

	}

	private Node search(Node root, String x) {
		if (root == null) {
			return null;
		} else if (x.equals(root.element.getDepName())) {
			return root;
		} else if (x.compareTo(root.element.getDepName()) > 0) {
			return search(root.rightChild, x);
		} else {
			return search(root.leftChild, x);
		}

	}

	// create inorderTraversal() method for traversing AVL Tree in in-order form
	public String inorderTraversal() {
		String str = "";
		return inorderTraversal(rootNode, str);
	}

	private String inorderTraversal(Node head, String str) {
		if (head != null) {
			str = inorderTraversal(head.leftChild, str);
			str += head.element.info() + "\n";
			str = inorderTraversal(head.rightChild, str);
		}
		return str;
	}

	public void getDepartment(ComboBox cb) {
		getDepartment(rootNode, cb);

	}

	private void getDepartment(Node root, ComboBox cb) {

		if (root != null) {
			getDepartment(root.leftChild, cb);
			cb.getItems().add(root.element.getDepName());
			getDepartment(root.rightChild, cb);
		}
	}

	// create preorderTraversal() method for traversing AVL Tree in pre-order form
	public void preorderTraversal() {
		preorderTraversal(rootNode);
	}

	private void preorderTraversal(Node head) {
		if (head != null) {
			System.out.print(head.element + " ");
			preorderTraversal(head.leftChild);
			preorderTraversal(head.rightChild);
		}
	}

	// create postorderTraversal() method for traversing AVL Tree in post-order form
	public void postorderTraversal() {
		postorderTraversal(rootNode);
	}

	private void postorderTraversal(Node head) {
		if (head != null) {
			postorderTraversal(head.leftChild);
			postorderTraversal(head.rightChild);
			System.out.print(head.element + " ");
		}
	}

	public Node delete(String x) {
		rootNode = delete(rootNode, x);
		return rootNode;
	}

	private Node delete(Node root, String x) {
		Node temp, child = null;
		if (root == null) {
			System.out.println("element not found");
			return null;
		} else if (x.compareTo(root.element.getDepName()) > 0) {
			root.rightChild = delete(root.rightChild, x);
		} else if (x.compareTo(root.element.getDepName()) < 0) {
			root.leftChild = delete(root.leftChild, x);
		} else if (root.rightChild != null && root.leftChild != null) {
			temp = findMin(root.rightChild);
			root.element.setDepName(temp.element.getDepName());
			root.element.setFileName(temp.element.getFileName());

			root.rightChild = delete(root.rightChild, temp.element.getDepName());
		} else {
			if (root.leftChild == null) {
				child = root.rightChild;
			}
			if (root.rightChild == null) {
				child = root.leftChild;
			}
			return child;
		}
		return root;

	}

	public void getAllFileNameDep() throws IOException {
		saveAllDataDep(rootNode);
	}

	private void saveAllDataDep(Node head) throws IOException {
		if (head != null) {
			saveAllDataDep(head.leftChild);
			FileWriter save = new FileWriter(new File(head.element.getFileName()), false);
			save.write(head.element.table.SaveToFile());
			save.close();
			saveAllDataDep(head.rightChild);
		}
	}

	public Node findMin(Node root) {
		Node temp = root;
		Node prev = temp;

		while (temp != null) {
			prev = temp;
			temp = temp.leftChild;
		}
		return prev;
	}
}
// create AVLTree class to construct AVL Tree  
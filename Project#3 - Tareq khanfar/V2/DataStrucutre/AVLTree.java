package DataStrucutre;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.ComboBox;

public class AVLTree {
	Node root;

	int height(Node N) {
		if (N == null)
			return -1;
		return N.h;
	}

	public int getHeight() {
		return height(root);
	}

	Node rotateRight(Node b) {
		Node a = b.left;
		Node c = a.right;

		a.right = b;
		b.left = c;

		b.h = Math.max(height(b.left), height(b.right)) + 1;
		a.h = Math.max(height(a.left), height(a.right)) + 1;

		return a;
	}

	Node rotateLeft(Node a) {
		Node b = a.right;
		Node c = b.left;

		b.left = a;
		a.right = c;

		a.h = Math.max(height(a.left), height(a.right)) + 1;
		b.h = Math.max(height(b.left), height(b.right)) + 1;

		return b;
	}

	int getBalance(Node N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	// create insertElement() to insert element to to the AVL Tree

	public void insertElement(Department dep) {
		root = insert(root, dep);
	}

	private Node insert(Node node, Department key) {
		if (node == null)
			return (new Node(key));

		if (key.getDepName().compareTo(node.element.getDepName()) < 0)
			node.left = insert(node.left, key);
		else if (key.getDepName().compareTo(node.element.getDepName()) > 0)
			node.right = insert(node.right, key);
		else
			return node;

		node.h = 1 + Math.max(height(node.left), height(node.right));

		int balance = getBalance(node);
		if (balance > 1 && key.getDepName().compareTo(node.left.element.getDepName()) < 0)
			return rotateRight(node);

		if (balance < -1 && key.getDepName().compareTo(node.right.element.getDepName()) > 0)
			return rotateLeft(node);

		if (balance > 1 && key.getDepName().compareTo(node.left.element.getDepName()) > 0) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		if (balance < -1 && key.getDepName().compareTo(node.right.element.getDepName()) < 0) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}

		return node;
	}

	Node minValueNode(Node node) {
		Node temp;
		for (temp = node; temp.left != null; temp = temp.left)
			;

		return temp;
	}

	// create searchElement() method to find an element in the AVL Tree
	public Node search(String x) {
		if (root == null) {
			return null;
		} else {
			return search(root, x);
		}

	}

	private Node search(Node root, String x) {
		if (root == null) {
			return null;
		} else if (x.equals(root.element.getDepName())) {
			return root;
		} else if (x.compareTo(root.element.getDepName()) > 0) {
			return search(root.right, x);
		} else {
			return search(root.left, x);
		}

	}

	// create inorderTraversal() method for traversing AVL Tree in in-order form
	public String inorderTraversal() {
		String str = "";
		return inorderTraversal(root, str);
	}

	private String inorderTraversal(Node head, String str) {
		if (head != null) {
			str = inorderTraversal(head.left, str);
			str += head.element.info() + "\n";
			str = inorderTraversal(head.right, str);
		}
		return str;
	}

	public void getDepartment(ComboBox cb) {
		getDepartment(root, cb);

	}

	private void getDepartment(Node root, ComboBox cb) {

		if (root != null) {
			getDepartment(root.left, cb);
			cb.getItems().add(root.element.getDepName());
			getDepartment(root.right, cb);
		}
	}

	// create preorderTraversal() method for traversing AVL Tree in pre-order form
	public void preorderTraversal() {
		preorderTraversal(root);
	}

	private void preorderTraversal(Node head) {
		if (head != null) {
			System.out.print(head.element + " ");
			preorderTraversal(head.left);
			preorderTraversal(head.right);
		}
	}

	// create postorderTraversal() method for traversing AVL Tree in post-order form
	public void postorderTraversal() {
		postorderTraversal(root);
	}

	private void postorderTraversal(Node head) {
		if (head != null) {
			postorderTraversal(head.left);
			postorderTraversal(head.right);
			System.out.print(head.element + " ");
		}
	}

	public void getAllFileNameDep() throws IOException {
		saveAllDataDep(root);
	}

	private void saveAllDataDep(Node head) throws IOException {
		if (head != null) {
			saveAllDataDep(head.left);
			FileWriter save = new FileWriter(new File(head.element.getFileName()), false);
			save.write(head.element.table.SaveToFile());
			save.close();
			saveAllDataDep(head.right);
		}
	}

	public Node findMin(Node root) {
		Node temp = root;
		Node prev = temp;

		while (temp != null) {
			prev = temp;
			temp = temp.left;
		}
		return prev;
	}

	public Node delete(String x) {
		root = deleteNode(root, x);
		return root;
	}

	private Node deleteNode(Node root, String key) {
		if (root == null)
			return root;

		if (key.compareTo(root.element.getDepName()) < 0)
			root.left = deleteNode(root.left, key);

		else if (key.compareTo(root.element.getDepName()) > 0)
			root.right = deleteNode(root.right, key);

		else {

			if ((root.left == null) || (root.right == null)) {
				Node temp = null;
				if (temp == root.left)
					temp = root.right;
				else
					temp = root.left;

				if (temp == null) {
					temp = root;
					root = null;
				} else
					root = temp;
			} else {

				Node temp = findMin(root.right);

				root.element.setDepName(temp.element.getDepName());
				root.element.setFileName(temp.element.getFileName());

				root.right = deleteNode(root.right, temp.element.getDepName());
			}
		}

		if (root == null)
			return root;

		root.h = Math.max(height(root.left), height(root.right)) + 1;
		int balance = getBalance(root);

		if (balance > 1 && getBalance(root.left) >= 0)
			return rotateRight(root);

		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}

		if (balance < -1 && getBalance(root.right) <= 0)
			return rotateLeft(root);

		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}

		return root;
	}

}
// create AVLTree class to construct AVL Tree  
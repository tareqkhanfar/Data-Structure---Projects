package DataStrucutre;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("Departments.txt"));
		AVLTree tree = new AVLTree();
		while (in.hasNextLine()) {
			String[] temp = in.nextLine().split("/");
			tree.insertElement(new Department(temp[0], temp[1]));
		}
		in.close();
		tree.inorderTraversal();

		HashTable table = new HashTable(3);
		in = new Scanner(new File("cs.txt"));
		while (in.hasNextLine()) {
			String[] temp = in.nextLine().split("/");
			table.insert(
					new Student(temp[0], Integer.parseInt(temp[1]), Double.parseDouble(temp[2]), temp[3].charAt(0)));
		}
		table.printHashTable();
		System.out.println(tree.getHeight());
	}

}

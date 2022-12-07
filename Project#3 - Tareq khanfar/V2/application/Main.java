package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import DataStrucutre.AVLTree;
import DataStrucutre.Department;
import DataStrucutre.Node;
import DataStrucutre.Student;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Main extends Application {
	static Stage stage;
	static BorderPane root = new BorderPane();
	static AVLTree tree = new AVLTree();
	// static HashTable table = new HashTable(1);
	static TextField Tsize = new TextField();
	static ComboBox CDepName = new ComboBox();

	private File data, read;

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		this.stage = primaryStage;
		InputStream stream = new FileInputStream(
				"C:\\Users\\Zaytona\\Desktop\\DataStructure2022\\ProjectThree\\src\\application\\home.jpg");

		BackgroundImage myBI = new BackgroundImage(new Image(stream, 1360, 690, false, true), BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));

		CDepName.setOnAction(e -> {
			if (CDepName.getValue() != null) {
				Node temp = tree.search(CDepName.getValue().toString());
				Main.Tsize.setText(temp.element.table.getSize() + "");
			}

		});
		Label DepartmentName = new Label("Department Name : ");
		DepartmentName.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;");

		DepartmentName.setFont(new Font(30));

		Label fileName = new Label("File Name: ");
		fileName.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;");

		fileName.setFont(new Font(30));

		Label path = new Label("");

		Label tableSize = new Label(" Table Size : ");
		tableSize.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;");

		tableSize.setFont(new Font(30));
		Tsize.setFont(new Font(30));

		Tsize.setPrefSize(220, 80);
		Tsize.setStyle(
				"-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;" + "-fx-background-radius:15");

		Label high = new Label(" Hight Tree : ");
		high.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;");

		high.setFont(new Font(30));
		TextField THight = new TextField();
		THight.setPrefSize(220, 80);
		THight.setStyle(
				"-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;" + "-fx-background-radius:15");
		THight.setFont(new Font(30));
		THight.setText(tree.getHeight() + "");

		Button selectFile = new Button("Click here");

		selectFile.setOnAction(e -> {

			if (Main.CDepName.getValue() == null) {
				MessageError.MessageWarningNotSelectDep();
			} else {
				FileChooser fch = new FileChooser(); // this open window to select source data

				fch.setTitle("Open Resource File");
				fch.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
				data = fch.showOpenDialog(new Stage()); // open window and if select file , return value of type
				Scanner in;
				try {
					in = new Scanner(data);
					String correctFile = tree.search(CDepName.getValue().toString()).element.getFileName();
					if (correctFile.equals(data.getName())) {

						Node tableStudent = tree.search(CDepName.getValue().toString());
						while (in.hasNextLine()) {
							String temp[] = in.nextLine().split("/");
							tableStudent.element.table.insert(new Student(temp[0], Integer.parseInt(temp[1]),
									Double.parseDouble(temp[2]), temp[3].charAt(0)));
						}
						in.close();
						Tsize.setText(tableStudent.element.table.getSize() + "");
						path.setText(data.getPath()); // file

						MessageError.MessageSaveData();
					} else {
						MessageError.selectCorrectFile(correctFile);
					}
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

			}

		});

		GridPane gp = new GridPane();
		gp.setVgap(10);
		gp.setHgap(10);
		gp.setAlignment(Pos.CENTER);
		gp.addRow(0, DepartmentName, CDepName);
		gp.addRow(1, fileName, selectFile, path);
		gp.addRow(2, tableSize, Tsize);
		gp.addRow(3, high, THight);

		root.setLeft(gp);

		try {
			MenuBar menuBar = new MenuBar();
			Menu file = new Menu("File");
			Menu print = new Menu("Print");
			Menu insert = new Menu("Insert");
			Menu delete = new Menu("Delete");

			Menu search = new Menu("Search");

			MenuItem printDepartment = new MenuItem("Department sorted.");
			MenuItem searchDepartment = new MenuItem("Search Department ");
			MenuItem addDepartment = new MenuItem("Insert New Dep.");
			MenuItem deleteDepartment = new MenuItem("Delete Department");

			MenuItem printTableSize = new MenuItem("Table Size");
			MenuItem hashedTable = new MenuItem("Hashed Table");
			MenuItem printHashFun = new MenuItem("Hash Function");
			MenuItem insertRecord = new MenuItem("insert Student");
			MenuItem searchStudent = new MenuItem("Search Student");
			MenuItem deleteStudent = new MenuItem("Delete Student");

			MenuItem readFile = new MenuItem("Read From File");
			MenuItem saveCurrentHash = new MenuItem("save student in Dep");
			MenuItem saveAllDep = new MenuItem("save All Dep");

			MenuItem exit = new MenuItem("Exit");
			exit.setOnAction(e -> {
				System.exit(0);
			});
			menuBar.prefHeight(50);
			file.getItems().addAll(readFile, saveCurrentHash, saveAllDep, exit);
			print.getItems().addAll(printDepartment, printTableSize, hashedTable, printHashFun);
			insert.getItems().addAll(addDepartment, insertRecord);
			delete.getItems().addAll(deleteDepartment, deleteStudent);
			search.getItems().addAll(searchDepartment, searchStudent);

			menuBar.getMenus().addAll(file, print, insert, delete, search);

//root.setTop(menuBar);

			Label title = new Label("     Data Structure for Birzeit University      ");
			title.setFont(new Font(40));
			title.setAlignment(Pos.CENTER);
			title.setStyle("-fx-background-color:#B2B2B2;\n" + "-fx-background-radius:40;\n ");

			VBox vv = new VBox(30);
			vv.setAlignment(Pos.CENTER);
			vv.getChildren().addAll(menuBar, title);
			root.setTop(vv);
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();

			//////////////////////////////////////////////////////////////////////////////////////
			saveAllDep.setOnAction(e -> {
				FileWriter write;

				try {
					FileChooser fch = new FileChooser(); // this open window to select source data

					fch.setTitle("Open Resource File");
					fch.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
					File out = fch.showOpenDialog(new Stage()); // open window and if select file , return value of type
					write = new FileWriter(out, false);

					write.write(tree.inorderTraversal());
					write.close();
					MessageError.MessageSaveData();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
				}

			});

			saveCurrentHash.setOnAction(e -> {
				if (Main.CDepName.getValue() == null) {
					MessageError.MessageWarningNotSelectDep();
				} else {
					FileChooser fch = new FileChooser(); // this open window to select source data
					fch.setTitle("Open Resource File");
					fch.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
					File out = fch.showOpenDialog(new Stage()); // open window and if select file , return value of type

					Node dep = tree.search(CDepName.getValue().toString());
					String correctFile = dep.element.getFileName();
					if (correctFile.equals(out.getName())) {

						FileWriter write;
						try {
							write = new FileWriter(out, false);
							write.write(dep.element.table.TOSTRING());
							write.close();
							MessageError.MessageSaveData();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else {
						MessageError.selectCorrectFile(correctFile);
					}
				}
			});
			addDepartment.setOnAction(e -> {// to check particular ticket if reserved or not
				Stage s = new Stage();
				GridPane v = new GridPane();
				v.setStyle("	-fx-background-color: linear-gradient(to bottom right, #FF7F58, #6A5ACD);");

				Label Title = new Label("        Insert Department        ");
				Title.setFont(new Font(40));
				Title.setAlignment(Pos.CENTER);
				Title.setStyle("-fx-background-color:#0CBF83;\n" + "-fx-background-radius:40;\n ");
				v.setAlignment(Pos.CENTER);
				v.setVgap(10);
				v.setHgap(10);
				Label DepName = new Label("Department Name : ");
				DepName.setFont(new Font(20));

				Label relatedName = new Label("Related Data Name: ");
				relatedName.setFont(new Font(20));

				TextField TDepName = new TextField();
				TDepName.setPrefSize(500, 80);
				TDepName.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;"
						+ "-fx-background-radius:15");
				TDepName.setFont(new Font(30));

				TextField TrelatedName = new TextField();

				TrelatedName.setPrefSize(500, 80);
				TrelatedName.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;"
						+ "-fx-background-radius:15");
				TrelatedName.setFont(new Font(30));

				Button add = new Button("Add");

				add.setStyle("-fx-background-color:#03BD16;  -fx-font-size:20;\n");
				add.setOnMouseEntered(e1 -> {
					add.setStyle("-fx-background-color:#FF6B92;-fx-font-size:20;\n");
				});

				add.setOnMouseExited(e2 -> {
					add.setStyle("-fx-background-color:#03BD16;  -fx-font-size:20;\n" + "\n");
				});

				v.addRow(0, Title);

				v.addRow(2, DepName, TDepName);
				v.addRow(3, relatedName, TrelatedName);

				v.addRow(6, add);
				Scene s2 = new Scene(v, 640, 300);
				s.setScene(s2);
				s.show();
				add.setOnAction(e2 -> {
					tree.insertElement(new Department(TDepName.getText(), TrelatedName.getText()));
					THight.setText(tree.getHeight() + "");
					CDepName.getItems().clear();
					tree.getDepartment(CDepName);
					MessageError.MessageAddDepartment();

				});

			});

			searchDepartment.setOnAction(e -> {
				Main.stage.getScene().setRoot(new SearchDepartment());
			});

			searchStudent.setOnAction(e -> {
				Main.stage.getScene().setRoot(new SearchStudent());

			});

			insertRecord.setOnAction(e -> {
				if (Main.CDepName.getValue() == null) {
					MessageError.MessageWarningNotSelectDep();
				} else {
					Node temp = tree.search(CDepName.getValue().toString());

					Main.stage.getScene().setRoot(new AddStudent(temp));
				}
			});

			deleteDepartment.setOnAction(e -> {
				Stage s = new Stage();
				GridPane v = new GridPane();
				v.setStyle("	-fx-background-color: linear-gradient(to bottom right, #FF7F58, #6A5ACD);");

				v.setAlignment(Pos.CENTER);
				v.setVgap(10);
				v.setHgap(10);
				Label Title = new Label("        Delete  Dep.        ");
				Title.setFont(new Font(40));
				Title.setAlignment(Pos.CENTER);
				Title.setStyle("-fx-background-color:#FF6B92;\n" + "-fx-background-radius:40;\n ");
				Label name = new Label("Name of Department : ");
				name.setFont(new Font(20));

				TextField Tname = new TextField();
				Tname.setPrefSize(500, 80);
				Tname.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;"
						+ "-fx-background-radius:15");
				Tname.setFont(new Font(30));
				Button Delete = new Button("Delete");

				v.addRow(0, Title);
				v.addRow(2, name, Tname);

				v.addRow(5, Delete);
				Scene s2 = new Scene(v, 850, 350);
				s.setScene(s2);
				s.show();

				Delete.setStyle("-fx-background-color:#FF6B92;  -fx-font-size:20;\n");
				Delete.setOnMouseEntered(e1 -> {
					Delete.setStyle("-fx-background-color:#69FFFF;-fx-font-size:20;\n");
				});

				Delete.setOnMouseExited(e2 -> {
					Delete.setStyle("-fx-background-color:#FF6B92;  -fx-font-size:20;\n" + "\n");
				});
				Delete.setOnAction(e2 -> {
					if (Main.CDepName.getValue() == null) {
						MessageError.MessageWarningNotSelectDep();
					} else {
						tree.delete(Tname.getText());
						THight.setText(tree.getHeight() + "");
						CDepName.getItems().clear();
						tree.getDepartment(CDepName);
						MessageError.MessageDeleteDep();
					}
				});
			});

			readFile.setOnAction(e -> {
				FileChooser fch = new FileChooser(); // this open window to select source data

				fch.setTitle("Open Resource File");
				fch.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
				read = fch.showOpenDialog(new Stage()); // open window and if select file , return value of type
														// file
				if (read != null) {
					// if user select file then value of data not equal null
					try {
						Scanner in = new Scanner(read);
						while (in.hasNextLine()) {
							String[] temp = in.nextLine().split("/");
							tree.insertElement(new Department(temp[0], temp[1]));
						}
						in.close();
						tree.getDepartment(CDepName);
						THight.setText(tree.getHeight() + "");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			printDepartment.setOnAction(e -> {

				Main.stage.getScene().setRoot(new showAllDepartment());

			});

			hashedTable.setOnAction(e -> {
				if (Main.CDepName.getValue() == null) {
					MessageError.MessageWarningNotSelectDep();
				} else {
					Main.stage.getScene().setRoot(new DisplayAllHashTable());
				}
			});

			deleteStudent.setOnAction(e -> {
				Stage s = new Stage();
				GridPane v = new GridPane();
				v.setStyle("	-fx-background-color: linear-gradient(to bottom right, #FF7F58, #6A5ACD);");

				v.setAlignment(Pos.CENTER);
				v.setVgap(10);
				v.setHgap(10);
				Label Title = new Label("        Delete  Student.        ");
				Title.setFont(new Font(40));
				Title.setAlignment(Pos.CENTER);
				Title.setStyle("-fx-background-color:#FF6B92;\n" + "-fx-background-radius:40;\n ");
				Label name = new Label("Name of Student : ");
				name.setFont(new Font(20));

				TextField Tname = new TextField();
				Tname.setPrefSize(500, 80);
				Tname.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;"
						+ "-fx-background-radius:15");
				Tname.setFont(new Font(30));
				Button Delete = new Button("Delete");

				v.addRow(0, Title);
				v.addRow(2, name, Tname);

				v.addRow(5, Delete);
				Scene s2 = new Scene(v, 850, 350);
				s.setScene(s2);
				s.show();

				Delete.setStyle("-fx-background-color:#FF6B92;  -fx-font-size:20;\n");
				Delete.setOnMouseEntered(e1 -> {
					Delete.setStyle("-fx-background-color:#69FFFF;-fx-font-size:20;\n");
				});

				Delete.setOnMouseExited(e2 -> {
					Delete.setStyle("-fx-background-color:#FF6B92;  -fx-font-size:20;\n" + "\n");
				});
				Delete.setOnAction(e2 -> {
					if (Main.CDepName.getValue() == null) {
						MessageError.MessageWarningNotSelectDep();
					} else {
						Node tempStudent = Main.tree.search(Main.CDepName.getValue().toString());
						tempStudent.element.table.remove(Tname.getText());
						MessageError.MessageDeleteStudent();
					}
				});
			});
			printHashFun.setOnAction(e -> {
				Stage s = new Stage();
				TextArea hashFun = new TextArea();
				String hashWord = " Fun(String) = hashValue % arraySize \n";
				hashWord += "Fun2(String) =  7 - (hashValue % 7) \n";
				hashWord += "hashValue = (hashValue + stepSize) % arraySize \n";

				hashFun.setText(hashWord);
				Scene s3 = new Scene(hashFun);
				s.setScene(s3);
				s.show();
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

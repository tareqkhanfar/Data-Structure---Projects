package application;

import java.io.File;

import DataStrucutre.Node;
import DataStrucutre.Student;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AddStudent extends BorderPane {
	File data;

	public AddStudent(Node temp) {
		setStyle("	-fx-background-color: linear-gradient(to bottom right, #FF7F58, #6A5ACD);");

		GridPane v = new GridPane();
		Label Title = new Label("        Insert Student        ");
		Title.setFont(new Font(40));

		Title.setAlignment(Pos.CENTER);
		Title.setStyle("-fx-background-color:#0CBF83;\n" + "-fx-background-radius:40;\n ");
		v.setAlignment(Pos.CENTER);
		v.setVgap(10);
		v.setHgap(10);

		Label name = new Label("Student Name : ");
		name.setFont(new Font(20));

		Label id = new Label("Student ID: ");
		id.setFont(new Font(20));

		Label avg = new Label(" Average : ");
		avg.setFont(new Font(20));

		TextField Tname = new TextField();

		Tname.setPrefSize(500, 80);
		Tname.setStyle(
				"-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;" + "-fx-background-radius:15");
		Tname.setFont(new Font(30));

		TextField Tid = new TextField();

		Tid.setPrefSize(500, 80);
		Tid.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;" + "-fx-background-radius:15");
		Tid.setFont(new Font(30));

		RadioButton m = new RadioButton("Male"), f = new RadioButton("Female");
		m.setPrefSize(50, 50);
		f.setPrefSize(50, 50);

		ToggleGroup tg = new ToggleGroup();
		tg.getToggles().addAll(m, f);
		TextField Tavg = new TextField();
		Tavg.setPrefSize(500, 80);
		Tavg.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;" + "-fx-background-radius:15");
		Tavg.setFont(new Font(30));

		Button add = new Button("Add");
		Button Home = new Button("Home");

		Home.setStyle("-fx-background-color:#FF7C9F; -fx-font-size:20;\n");
		Home.setOnMouseEntered(e5 -> {
			Home.setStyle("-fx-background-color:#FF3D7E;-fx-font-size:20;\n");
		});
		Home.setOnMouseExited(e6 -> {
			Home.setStyle("-fx-background-color:#FF7C9F;  -fx-font-size:20;\n" + "\n");
		});
		Home.setOnAction(e -> {
			Main.stage.getScene().setRoot(Main.root);

		});

		add.setStyle("-fx-background-color:#03BD16;  -fx-font-size:20;\n");
		add.setOnMouseEntered(e1 -> {
			add.setStyle("-fx-background-color:#FF6B92;-fx-font-size:20;\n");
		});

		add.setOnMouseExited(e2 -> {
			add.setStyle("-fx-background-color:#03BD16;  -fx-font-size:20;\n" + "\n");
		});

		add.setPrefSize(150, 60);
		Home.setPrefSize(150, 60);

		v.addRow(1, name, Tname);
		v.addRow(2, id, Tid);
		v.addRow(3, avg, Tavg);
		v.addRow(4, m, f);

		VBox right = new VBox(10);
		right.setAlignment(Pos.CENTER);
		right.getChildren().addAll(add, Home);
		setCenter(v);
		setRight(right);
		setTop(Title);
		add.setOnAction(e2 -> {
			if (Main.CDepName.getValue().toString() == null || Main.CDepName.getValue().toString() == "") {
				MessageError.MessageWarningNotSelectDep();
			} else {
				try {
					char gender = ' ';
					if (m.isSelected()) {
						gender = 'M';
					} else if (f.isSelected()) {
						gender = 'F';

					}
					temp.element.table.insert(new Student(Tname.getText(), Integer.parseInt(Tid.getText()),
							Double.parseDouble(Tavg.getText()), gender));
					MessageError.MessageAddStudent();

					Main.Tsize.setText(temp.element.table.getSize() + "");
				} catch (Exception ee) {
					MessageError.MessageWarningEmptyData();
				}
			}

		});

	}

}

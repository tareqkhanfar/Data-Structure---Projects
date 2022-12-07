package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class showAllDepartment extends BorderPane {

	public showAllDepartment() {
		Label Title = new Label(
				"                            Display All Departments                                   ");
		Title.setFont(new Font(40));
		Title.setStyle("-fx-background-color:#0CBF83;\n" + "-fx-background-radius:40;\n ");
		Button search = new Button("Display ALL Flights");
		search.setPrefSize(250, 60);

		Button Home = new Button("HOME");
		Home.setPrefSize(150, 60);

		Button clear = new Button("Clear");
		clear.setPrefSize(150, 60);

		search.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:20;\n");
		search.setOnMouseEntered(e -> {
			search.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
		search.setOnMouseExited(e -> {
			search.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n" + "\n");
		});
		TextArea info = new TextArea();
		search.setOnAction(e -> {
			info.setText(Main.tree.inorderTraversal());
		});

		VBox v = new VBox(10);
		v.setAlignment(Pos.CENTER);
		HBox h = new HBox(20);

		h.setAlignment(Pos.CENTER);
		h.getChildren().addAll(search, clear, Home);
		v.getChildren().addAll(Title, h);
		Home.setPrefSize(150, 60);
		Home.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:20;\n");
		Home.setOnMouseEntered(e5 -> {
			Home.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
		Home.setOnMouseExited(e6 -> {
			Home.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n" + "\n");
		});
		Home.setOnAction(e -> { // to return home page
			Main.stage.getScene().setRoot(Main.root);
		});
		clear.setStyle("-fx-background-color:#FF69A6; -fx-font-size:20;\n");
		clear.setOnMouseEntered(e5 -> {
			clear.setStyle("-fx-background-color:#FA0667;-fx-font-size:20;\n");
		});
		clear.setOnMouseExited(e6 -> {
			clear.setStyle("-fx-background-color:#FF69A6;  -fx-font-size:20;\n" + "\n");
		});
		clear.setOnAction(e -> {
			// clear all texts existing textArea
			info.clear();
		});
		setTop(v);
		setCenter(info);

	}

}

package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SearchDepartment extends BorderPane {
	public SearchDepartment() {
		setStyle("	-fx-background-color: linear-gradient(to bottom right, #FF7F58, #6A5ACD);");

		Label name = new Label("Name of Dep. :");
		name.setFont(new Font(20));
		TextField Tname = new TextField();
		Tname.setPrefSize(500, 80);
		Tname.setStyle(
				"-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;" + "-fx-background-radius:15");
		Tname.setFont(new Font(30));

		Button Home = new Button("Home");
		Label Title = new Label("Search a Department");
		Title.setFont(new Font(40));
		HBox h = new HBox(Title);
		h.setAlignment(Pos.CENTER);
		h.setStyle("-fx-background-color:#0CBF83;\n" + "-fx-background-radius:40;\n ");
		VBox v = new VBox(7);
		v.setAlignment(Pos.CENTER);
		HBox h2 = new HBox(20);
		h2.setAlignment(Pos.CENTER);

		h2.setPadding(new Insets(10));
		Home.setTranslateX(300);
		h2.getChildren().addAll(name, Tname, Home);

		TextArea info = new TextArea();
		v.getChildren().addAll(h, h2);
		info.setFont(new Font(30));

		setTop(v);
		setCenter(info);

		Tname.setOnAction(e -> {
			if (Main.CDepName.getValue() == null) {
				MessageError.MessageWarningNotSelectDep();
			} else if (Tname.getText() == null || Tname.getText() == "") {
				MessageError.MessageWarningEmptyData();

			} else {
				try {
					info.setText(Main.tree.search(Tname.getText()).element.toString());

				} catch (NullPointerException e2) {
					MessageError.MessageNotExistDep();
				}
			}

		});
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
	}
}

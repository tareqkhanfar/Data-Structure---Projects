package application;

import DataStrucutre.Node;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DisplayAllHashTable extends BorderPane {

	public DisplayAllHashTable() {
		setStyle("	-fx-background-color: linear-gradient(to bottom right, #FF7F58, #6A5ACD);");

		Label Title = new Label(
				"                            Display All Hash Table                                   ");
		Title.setFont(new Font(40));
		Title.setStyle("-fx-background-color:#0CBF83;\n" + "-fx-background-radius:40;\n ");

		Button Home = new Button("HOME");
		Home.setPrefSize(150, 60);

		TextArea info = new TextArea();
		info.setFont(new Font(30));
		Node temp = Main.tree.search(Main.CDepName.getValue().toString());
		info.setText(temp.element.table.printAllHashTable());

		VBox v = new VBox(10);
		v.setAlignment(Pos.CENTER);
		HBox h = new HBox(20);

		h.setAlignment(Pos.CENTER);
		h.getChildren().addAll(Home);
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

		setTop(v);
		setCenter(info);

	}

}

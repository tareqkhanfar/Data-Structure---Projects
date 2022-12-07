package application;

import PROJECT.Flight;
import PROJECT.Passanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DisplayAllPassanger extends BorderPane {

	public DisplayAllPassanger() {
		Label Title = new Label ("                            Display All Passangers                                   ") ;
		Title.setFont(new Font (40));
		Title.setStyle("-fx-background-color:#0CBF83;\n" + "-fx-background-radius:40;\n ");
		Button search = new Button ("Display ALL Passangers") ;			search.setPrefSize(250 , 60);
	
        Button Home = new Button ("HOME") ;		Home.setPrefSize(150 , 60);

        Button clear = new Button ("Clear") ;		clear.setPrefSize(150 , 60);


		search.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:20;\n");
		search.setOnMouseEntered(e->{
			search.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
		search.setOnMouseExited(e->{
			search.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
					+ "\n");});		
		TextArea info = new TextArea () ;
search.setOnAction(e->{
	// get all information about all flight and display on textArea

info.setText(Main.list.DisplayAllPassanger());
});


VBox v = new VBox (10);
v.setAlignment(Pos.CENTER);
HBox h = new HBox (20) ;

h.setAlignment(Pos.CENTER);
h.getChildren().addAll(search , clear , Home) ;
v.getChildren().addAll(Title , h);
        Home.setPrefSize(150 , 60);
        Home.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:20;\n");
        Home.setOnMouseEntered(e5->{
        	Home.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
        Home.setOnMouseExited(e6->{
        	Home.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
					+ "\n");});	
Home.setOnAction(e->{// to return home page
	Main.stage.getScene().setRoot(Main.root);
	});
clear.setStyle("-fx-background-color:#FF69A6; -fx-font-size:20;\n");
clear.setOnMouseEntered(e5->{
	clear.setStyle("-fx-background-color:#FA0667;-fx-font-size:20;\n");
});
clear.setOnMouseExited(e6->{
	clear.setStyle("-fx-background-color:#FF69A6;  -fx-font-size:20;\n"
			+ "\n");});	
clear.setOnAction(e->{
	// clear all texts existing textArea

	info.clear();
});
setTop(v) ;
setCenter(info);

	}
	
}

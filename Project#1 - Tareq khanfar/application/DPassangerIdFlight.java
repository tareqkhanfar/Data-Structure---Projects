package application;

import PROJECT.Node;
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

public class DPassangerIdFlight extends BorderPane{
public DPassangerIdFlight () {
	Label numberFlight = new Label ("Number of Flight :");
	numberFlight.setFont(new Font(20));
	TextField TnumberFlight = new TextField () ;
	TnumberFlight.setPrefSize(220, 30);

	Button search = new Button ("Search") ;
	Button Home = new Button ("Home") ;
	Label Title = new Label ("Search a Passangers BY Flight ID") ;
	Title.setFont(new Font (40));
	HBox h = new HBox (Title) ;
	h.setAlignment(Pos.CENTER) ;
	h.setStyle("-fx-background-color:#0CBF83;\n" + "-fx-background-radius:40;\n ");
	VBox v = new VBox (7);
	v.setAlignment(Pos.CENTER);
	HBox h2 = new HBox(20) ;
	h2.setAlignment(Pos.CENTER);

	h2.setPadding(new Insets(10));
	Home.setTranslateX(300);
	h2.getChildren().addAll(numberFlight , TnumberFlight , search ,Home );

	TextArea infoPassanger = new TextArea () ;
	v.getChildren().addAll(h , h2);

	setTop(v);
	setCenter(infoPassanger);
	search.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:20;\n");
	search.setOnMouseEntered(e->{
		search.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
	});
	search.setOnMouseExited(e->{
		search.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
				+ "\n");});		
	search.setOnAction(e->{
		try {
			 // send id flight and return nodeFlight
			Node n =  Main.list.search(Integer.parseInt(TnumberFlight.getText())) ;
			if (n == null ) {
				// if n equal zero this mean that flight does not exist in system
				MessageError.MessageNotExistFlight() ;
			}
			
			else {
				// else get all information about passengers in specific flight 
				infoPassanger.setText(n.getSpecificPassanger()) ;
			}
		}
		catch (NumberFormatException ex ) {
			// if textField id number is empty , show message to to let him know that 
			MessageError.MessageWarningEmptyData();

		}
		
	});
	Home.setStyle("-fx-background-color:#FF7C9F; -fx-font-size:20;\n");
	Home.setOnMouseEntered(e5->{
		Home.setStyle("-fx-background-color:#FF3D7E;-fx-font-size:20;\n");
	});
	Home.setOnMouseExited(e6->{
		Home.setStyle("-fx-background-color:#FF7C9F;  -fx-font-size:20;\n"
				+ "\n");});	
	Home.setOnAction(e->{
		   Main.stage.getScene().setRoot(Main.root) ;

	});
} 
}

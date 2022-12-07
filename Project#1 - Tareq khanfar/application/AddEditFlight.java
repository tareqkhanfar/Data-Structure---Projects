package application;


import PROJECT.Flight;
import PROJECT.LinkedList;
import PROJECT.Node;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AddEditFlight extends BorderPane {

	public AddEditFlight() {
		

		VBox right = new VBox (10)  ;
		right.setAlignment(Pos.CENTER);
		GridPane left = new GridPane() ;
		left.setAlignment(Pos.CENTER);
		left.setVgap(20);
		left.setHgap(20);
		left.setPadding(new Insets(10));
		Label number = new Label ("Flight Number") ;
		number.setFont(new Font(20));

		Label airline = new Label ("Airline Name ") ;		airline.setFont(new Font(20));

		Label source = new Label ("Source") ;		source.setFont(new Font(20));

		Label dest = new Label ("Destination") ;		dest.setFont(new Font(20));

		Label capacity = new Label ("Capacity") ;		capacity.setFont(new Font(20));


		Label Title = new Label ("Add - Remove - Edit Flights") ;
		Title.setFont(new Font (40));
		HBox h = new HBox (Title) ;
		h.setAlignment(Pos.CENTER) ;
		h.setStyle("-fx-background-color:#0CBF83;\n" + "-fx-background-radius:40;\n ");
setTop(h);
		TextField Tnumber = new TextField () ;
		Tnumber.setPrefSize(220, 30);

		TextField Tairline = new TextField () ;
		Tairline.setPrefSize(220, 30);

		TextField Tsource = new TextField () ;
		Tsource.setPrefSize(220, 30);

		TextField Tdest = new TextField () ;		Tdest.setPrefSize(220, 30);

		
		TextField Tcapacity = new TextField () ;		Tcapacity.setPrefSize(220, 30);

		
		Button add = new Button ("Add Flight") ;		add.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
				+ "\n");
		add.setOnMouseEntered(e->{
			add.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
		add.setOnMouseExited(e->{
			add.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
					+ "\n");});
		Button search = new Button ("Search Flight") ;		
		search.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:20;\n");
		search.setOnMouseEntered(e->{
			search.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
		search.setOnMouseExited(e->{
			search.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
					+ "\n");});		
		Button edit = new Button ("Edit information") ;		edit.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:15;\n");
		edit.setOnMouseEntered(e1->{
			edit.setStyle("-fx-background-color:#64D7FA;-fx-font-size:15;\n");
		});
		edit.setOnMouseExited(e2->{
			edit.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:15;\n"
					+ "\n");});		
		Button remove = new Button ("Remove Flight") ;		remove.setStyle("-fx-background-color:#FF7C9F; -fx-font-size:17;\n");
		remove.setOnMouseEntered(e3->{
			remove.setStyle("-fx-background-color:#FF3D7E;-fx-font-size:17;\n");
		});
		remove.setOnMouseExited(e4->{
			remove.setStyle("-fx-background-color:#FF7C9F;  -fx-font-size:17;\n"
					+ "\n");});	
		Button home = new Button ("HOME") ;	
		home.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:20;\n");
		home.setOnMouseEntered(e5->{
			home.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
		home.setOnMouseExited(e6->{
			home.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
					+ "\n");});	
		
		add.setPrefSize(150 , 60);
		search.setPrefSize(150 , 60);
		edit.setPrefSize(150 , 60);
		remove.setPrefSize(150 , 60);
		home.setPrefSize(150 , 60);

		left.addRow(0, number , Tnumber);
		left.addRow(1, airline , Tairline);
		left.addRow(2, source , Tsource);
		left.addRow(3, dest , Tdest);
		left.addRow(4, capacity , Tcapacity);
		
		right.getChildren().addAll(add ,search , edit ,remove ,home   ) ;
		home.setOnAction(e->{
			   Main.stage.getScene().setRoot(Main.root) ;

		});
		setCenter(left);
		setRight(right);
		
		
		//////////// Actions //////////////////////////////
		search.setOnAction(e->{
			try {
				
			// send id flight to fuctionSearch as an argumant , then return Flight (Node) 
		Flight data = (Flight)Main.list.search(Integer.parseInt(Tnumber.getText())).getValue();
		// show all properties flight in textFields
			Tairline.setText(data.getAirlineName());
			Tsource.setText(data.getSource());
			Tdest.setText(data.getDest());
			Tcapacity.setText(data.getCapacity()+"");
			}
		catch (NullPointerException ex) {
			// if flight does not exist in system , the system throw NullPointerException  , then handle here , show message to user
			MessageError.MessageNotExistFlight();

		}
			catch (NumberFormatException ex) {
				// if id flight empty , show to user message error
				MessageError.MessageWarningEmptyData();

			}

		});
		
		add.setOnAction(e->{
			try {
				// before add any flight , must a check flight if exist or not , if exist the system throw exception to handle here
				Main.list.checkIdFlight(Integer.parseInt(Tnumber.getText())) ;
				Main.list.addFlight(new Flight (Integer.parseInt(Tnumber.getText()) , Tairline.getText() , Tsource.getText() ,Tdest.getText(),Integer.parseInt(Tcapacity.getText())));
                MessageError.MessageAddFlight();
			}
			catch (IllegalArgumentException ex) {
				MessageError.MessageErrorFlight() ; // id flight already exist in system
			}
		});
		edit.setOnAction(e->{
			if (Tnumber.getText() == "" ||Tnumber.getText() ==null ) {
				// if id flight empty , show to user message error

				MessageError.MessageWarningEmptyData() ;
			}else {
				// send id flight to fuctionSearch as an argumant , then return Flight (Node) 

				Flight data = (Flight)Main.list.search(Integer.parseInt(Tnumber.getText())).getValue();
				// send all new changing on flight to flight

	            data.setFlightNumber(Integer.parseInt(Tnumber.getText())) ;
	            data.setAirlineName(Tairline.getText()) ;
	            data.setSource(Tsource.getText()) ;
	            data.setDest(Tdest.getText());
	            data.setCapacity(Integer.parseInt(Tcapacity.getText()));
				MessageError.MessageSaveData() ;

			}
			
		});
		remove.setOnAction(e->{
			if (Tnumber.getText() == "" ||Tnumber.getText() ==null ) {
				// if id flight empty , show to user message error

				MessageError.MessageWarningEmptyData() ;
			}
			else {
				 // send id flight , and remove flight from system
				Main.list.removeFlight(Integer.parseInt(Tnumber.getText())) ;
			}
			
		});

	
	}
}

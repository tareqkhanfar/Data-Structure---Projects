package application;

import java.util.Date;

import PROJECT.Flight;
import PROJECT.Node;
import PROJECT.NodeP;
import PROJECT.Passanger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ReserveTicket extends BorderPane {

	public ReserveTicket() {
		VBox right = new VBox (10)  ;
		right.setAlignment(Pos.CENTER);
		GridPane left = new GridPane() ;
		left.setAlignment(Pos.CENTER);
		left.setVgap(20);
		left.setHgap(20);
		left.setPadding(new Insets(10));
		Label number = new Label ("Flight Number") ;number.setFont(new Font(20));
		Label ticket = new Label ("Ticket Number ") ;ticket.setFont(new Font(20));
		Label name = new Label ("Full Name") ;name.setFont(new Font(20));
		Label passport = new Label ("Passport Number ") ;passport.setFont(new Font(20));
		Label nationality = new Label ("Nationality") ;nationality.setFont(new Font(20));
		Label dop = new Label ("Date Of Birth") ; dop.setFont(new Font(20));
		Label Title = new Label ("Reserve a Ticket ") ;
		Title.setFont(new Font (40));
		HBox h = new HBox (Title) ;
		h.setAlignment(Pos.CENTER) ;
		h.setStyle("-fx-background-color:#0CBF83;\n" + "-fx-background-radius:40;\n ");
setTop(h);
		
		TextField Tnumber = new TextField () ;		Tnumber.setPrefSize(220, 30);

		TextField Tticket = new TextField () ;		Tticket.setPrefSize(220, 30);

		Tticket.setText(Main.list.maxTicketNumber(Main.list.maxTicketNumber(-1))+1+"");
		TextField Tname = new TextField () ;		Tname.setPrefSize(220, 30);

		TextField Tpassport = new TextField () ;		Tpassport.setPrefSize(220, 30);

		TextField Tnationality = new TextField () ;		Tnationality.setPrefSize(220, 30);

		TextField Tdop = new TextField () ;		Tdop.setPrefSize(220, 30);
Tdop.setPromptText("yyyy/mm/dd");

		Button add = new Button ("Reserve a Ticket") ;
		Button search = new Button ("Search Flight") ;
		Button edit = new Button ("Edit information") ;
		Button home = new Button ("HOME") ;
		
		add.setPrefSize(220 , 60);
		search.setPrefSize(220 , 60);
		edit.setPrefSize(220 , 60);
		home.setPrefSize(220 , 60);

		left.addRow(0, number , Tnumber);
		left.addRow(1, ticket , Tticket);
		left.addRow(2, name , Tname);
		left.addRow(3, passport , Tpassport);
		left.addRow(4, nationality , Tnationality);
		left.addRow(5, dop , Tdop);

		right.getChildren().addAll(add ,search , edit  ,home   ) ;
		home.setOnAction(e->{
			   Main.stage.getScene().setRoot(Main.root) ;

		});
		add.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
				+ "\n");
		add.setOnMouseEntered(e->{
			add.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
		add.setOnMouseExited(e->{
			add.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
					+ "\n");});
		add.setOnAction(e->{
			try {
				 // send id flight and return nodeFlight

				Node n = Main.list.search (Integer.parseInt(Tnumber.getText())) ;
				if (n==null ) {
					// if n equal zero this mean that flight does not exist in system

					MessageError.MessageNotExistFlight() ;
				}
				else {
					// before add any passanger , must a check passanger if exist or not in specific flight , if exist the system throw exception to handle here

					Main.list.checkPassanger(n , Tpassport.getText()) ;
					
					String[] str = Tdop.getText().split("/"); // take data and split to day , month and year  ,and send to DataObject
                    Date d = new Date (Integer.parseInt(str[0])-1900 , Integer.parseInt(str[1]) - 1 , Integer.parseInt(str[2])) ;
					boolean flag = n.addPassangers( new Passanger(
							 
							Integer.parseInt(Tnumber.getText()) ,Integer.parseInt(Tticket.getText())  , Tname.getText() , Tpassport.getText() , Tnationality.getText() , d));
					 Main. list.maxTicketNumber (Integer.parseInt(Tticket.getText())) ;// send ticketNumber to save in maxTicketNumber and add one in another adding
					 if (flag) 
					// 	 if flag equal true this mean new passenger added successfully
						 MessageError.MessageAddPassanger();

				}
				
			}
			catch (IllegalArgumentException ex) {
				// if passenger already exist in flight , show message to user to let him know that
				MessageError.MessageErrorPassanger();
			}
			
		});
		search.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:20;\n");
		search.setOnMouseEntered(e->{
			search.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
		search.setOnMouseExited(e->{
			search.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
					+ "\n");});		
		search.setOnAction(e->{
			 // send id flight and return nodeFlight

			Node n = Main.list.search(Integer.parseInt(Tnumber.getText()));
			if (n==null) {
				// if n equal zero this mean that flight does not exist in system

				MessageError.MessageNotExistFlight();
			}
			else {
				Passanger m = n.search(Tpassport.getText()).value;
				if (m==null) {
					// if n equal zero this mean that passsenger does not exist in system

					MessageError.MessageNotExistPassanger();
				}
				else {
					// show all properties flight in textFields

					Tnumber.setText(m.getFlightNumber()+"");
					Tname.setText(m.getFullName());
					Tticket.setText(m.getTicketNumber()+"");
					Tnationality.setText(m.getNationality());
					Tpassport.setText(m.getPassportNumber());
					Date DOB = m.getDOB() ;
					Tdop.setText((1900+DOB.getYear())+ "/" +(DOB.getMonth()  +1  )+ "/" +DOB.getDate() ) ;

				}
				

			}
		}) ;
		
		edit.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:20;\n");
		edit.setOnMouseEntered(e1->{
			edit.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
		edit.setOnMouseExited(e2->{
			edit.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:15;\n"
					+ "\n");});		
		edit.setOnAction(e->{
			Node n = Main.list.search(Integer.parseInt(Tnumber.getText()));
			if (n==null) {
				// if n equal zero this mean that flight does not exist in system

				MessageError.MessageNotExistFlight();
			}
			else {
				Passanger m = n.search(Tpassport.getText()).value;
				if (m==null) {
					// if n equal zero this mean that passsenger does not exist in system
					MessageError.MessageNotExistPassanger();
				}
				else {
					// send all new changing on flight to flight

				m.setFlightNumber(Integer.parseInt(Tnumber.getText()));
				m.setTicketNumber(Integer.parseInt(Tticket.getText())) ;
				m.setFullName(Tname.getText());
				m.setNationality(Tnationality.getText());
				String[] str = Tdop.getText().split("/");
				System.out.println(str[0]) ;
				System.out.println(str[1]) ;
				System.out.println(str[2]) ;

                Date d = new Date (Integer.parseInt(str[0])- 1900 , Integer.parseInt(str[1]) - 1 , Integer.parseInt(str[2])) ;
				m.setDOB(d);
				MessageError.MessageSaveData();
				}
			}
		});
		
		home.setStyle("-fx-background-color:#9CCBBC; -fx-font-size:20;\n");
		home.setOnMouseEntered(e5->{
			home.setStyle("-fx-background-color:#64D7FA;-fx-font-size:20;\n");
		});
		home.setOnMouseExited(e6->{
			home.setStyle("-fx-background-color:#9CCBBC;  -fx-font-size:20;\n"
					+ "\n");});	
		
		
		setCenter(left);
		setRight(right);
		
		
		//////////// Actions //////////////////////////////
		
	}
}

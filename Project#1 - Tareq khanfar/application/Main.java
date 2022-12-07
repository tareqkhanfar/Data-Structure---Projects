package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;


import PROJECT.Flight;
import PROJECT.LinkedList;
import PROJECT.Node;
import PROJECT.NodeP;
import PROJECT.Passanger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {
	 static LinkedList list = new LinkedList() ;
	 static Stage stage;
   static BorderPane root = new BorderPane();

	@Override
	public void start(Stage stage) {
		this.stage  = stage ;
		BackgroundImage myBI= new BackgroundImage(new Image("icons/home.jpg",1360,690,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));

			VBox left = new VBox (10) ;
			left.setAlignment(Pos.CENTER);
			VBox right = new VBox (10) ;
right.setAlignment(Pos.CENTER);
			left.setPadding(new Insets(10));
			
			
			 MenuBar menuBar = new MenuBar();
			 Menu menu = new Menu ("File") ;
			 Menu menuFlight = new Menu ("Flight") ;
			 Menu menuPassanger = new Menu ("Passanger") ;
			 Menu menuSearch = new Menu ("Search") ;

			 Menu menuTicket = new Menu ("Ticket") ;
			 Menu report = new Menu ("Report") ;

			MenuItem DisplayAllFlight = new MenuItem ("Display All Flight");
			MenuItem DisplayAllPassanger = new MenuItem ("Display All Passanger") ;
			MenuItem Add_Edit_Fligh = new MenuItem ("Add_Edit_Fligh") ;
			MenuItem showInfoPassanger = new MenuItem ("showInfoPassanger") ;
			MenuItem Search = new MenuItem ("Search") ;
			MenuItem reserveTicket = new MenuItem ("reserveTicket") ;
			MenuItem cancelReserved = new MenuItem ("cancelReserved") ;
			MenuItem checkTicket = new MenuItem ("checkTicket") ;
			MenuItem Exit = new MenuItem ("Exit") ;
			 MenuItem readFligh = new MenuItem("Read flight File") ;

			 MenuItem readPassanger = new MenuItem("Read Passanger File") ;
			 MenuItem saveFilesFlight = new MenuItem("Save in Files (Flights)") ;
			 MenuItem saveFilesPassanger = new MenuItem("Save in Files (Passanger)") ;

			 MenuItem exit = new MenuItem("Exit Program") ;
			 MenuItem reportFlight = new MenuItem("Report Flight") ;
			 MenuItem reportPassanger = new MenuItem("Report Passanger") ;

			 
menuBar.prefHeight(50);
menu.getItems().addAll(readFligh ,readPassanger ,saveFilesFlight ,saveFilesPassanger, exit ) ;
menuFlight.getItems().addAll(Add_Edit_Fligh  , DisplayAllFlight ) ;
menuPassanger.getItems().addAll(showInfoPassanger , DisplayAllPassanger  ) ;
menuTicket.getItems().addAll(reserveTicket ,cancelReserved ,checkTicket  ) ;
report.getItems().addAll(reportFlight, reportPassanger) ;
menuSearch.getItems().add(Search) ;

menuBar.getMenus().addAll(menu , menuFlight , menuPassanger , menuSearch , menuTicket , report) ;

//root.setTop(menuBar);

 Label title = new Label ("     Ticket Reservation System      ") ;
	title.setFont(new Font (40));
	title.setAlignment(Pos.CENTER) ;
	title.setStyle("-fx-background-color:#B2B2B2;\n" + "-fx-background-radius:40;\n ");
 root.setRight(right);
 root.setLeft(left);
 VBox vv = new VBox (30) ;
 vv.setAlignment(Pos.CENTER);
 vv.getChildren().addAll(menuBar , title) ;
 root.setTop(vv);
 
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.setMaximized(true);
			stage.show();
			
// ##############	Actions 	###############################
			
			  readFligh.setOnAction(e->{
				  FileChooser fch = new FileChooser(); // this open window to select source data
				  
			  fch.setTitle("Open Resource File"); 
			  fch.getExtensionFilters().addAll( new
			  ExtensionFilter("Text Files", "*.txt") ); 
			  File data = fch.showOpenDialog(new Stage()) ; // open window 
			  if (data != null) { // if user select file then value of data not equal null
			  
			  Scanner in; 
			  try { 
				  in = new Scanner (data);
				  while (in.hasNextLine()) { String
			  str [] = in.nextLine().split(",") ; // to split line to fields and adding to the constructr Flight 
				  list.addFlight(new Flight(Integer.parseInt(str[0]) , str[1] , str[2] , str[3],Integer.parseInt(str[4])));
				  
			  
			  }
				  MessageError.MessageSaveData(); // after success add data in the system , show message to user data successfully added

			  
			  } catch (Exception e1) { // if happen error example one field is empty , show message to user
				MessageError.MessageWarningEmptyData	() ;
				}
			  
			  
			  } });
			  
			  readPassanger.setOnAction(e->{
				  FileChooser fch = new FileChooser() ; // this open window to select source data
				  fch.setTitle("Open Resource File");
				  fch.getExtensionFilters().addAll( new
						  ExtensionFilter("Text Files", "*.txt") );// make multiple extension 
						  File data = fch.showOpenDialog(new Stage()) ;
						if (data != null ) {// if user select file then value of data not equal null
							Scanner in;
							try {
								in = new Scanner (data);
								while (in.hasNextLine()) { // read data from file
									  String str [] = in.nextLine().split(",") ; // split line to fields 
										Node n = list.search (Integer.parseInt(str[0])) ; // search a flight by number Flight to adding current passanger for this flight
                                        String[] date = str[5].split("/"); // split data to day , month , and year , and then adding to the (Date Object)
                                        Date d = new Date (Integer.parseInt(date[2])-1900 , Integer.parseInt(date[1]) -1 , Integer.parseInt(date[0])) ;
								 n.addPassangers(new Passanger(Integer.parseInt(str[0]) ,Integer.parseInt(str[1]) ,str[2] , str[3] , str[4] , d ));
								  list.maxTicketNumber (Integer.parseInt(str[1])) ; // to store maximum Ticket Number

								 }
								  MessageError.MessageSaveData(); // After successfully added data show message for user

							} catch (Exception e1) {// if happen error example one field is empty , show message to user
								// TODO Auto-generated catch block
								MessageError.MessageWarningEmptyData	() ;
							}
							 
						}
			  });
			  exit.setOnAction(e->{
				  System.exit(0); // exit system
			  });
			 
			  
			  DisplayAllFlight.setOnAction(e->{ // this to move page Display All Flight in system
			   Main.stage.getScene().setRoot(new DisplayAllFlight()) ;
			  });
			  DisplayAllPassanger.setOnAction(e->{
				   Main.stage.getScene().setRoot(new DisplayAllPassanger()) ;// this to move page Display All Passanger in system

			  });
			  
			  Add_Edit_Fligh.setOnAction(e->{// this to move page Add , search , remove and edit All Flight in system
				
				   Main.stage.getScene().setRoot(new AddEditFlight()) ;

			  });
			  showInfoPassanger.setOnAction(e->{ // this to move page search a passanger that exist in particular flight 
				   Main.stage.getScene().setRoot(new DPassangerIdFlight()) ;

			  });
			  reserveTicket.setOnAction(e->{ // this to move page Reserve tickets for passanger 
				   Main.stage.getScene().setRoot(new ReserveTicket()) ;

			  });
		cancelReserved.setOnAction(e->{// this to move page cancel Reserve tickets for passanger 
          Stage s = new Stage () ;
          GridPane  v = new GridPane();
          v.setAlignment (Pos.CENTER) ;
          v.setVgap(10);       
          v.setHgap(10);
          Label Title = new Label ("        Cancel  Reserve        ") ;
	  		Title.setFont(new Font (40));
	  		Title.setAlignment(Pos.CENTER) ;
	  		Title.setStyle("-fx-background-color:#FF6B92;\n" + "-fx-background-radius:40;\n ");
          Label numberFlight = new Label ("Number of Flight : ") ;	          numberFlight.setFont(new Font(20));

          Label namePassanger = new Label ("Name of Passanger : ") ;	          namePassanger.setFont(new Font(20));

          TextField Tnumber = new TextField () ;Tnumber.setPrefSize(220, 30);
          TextField Tname = new TextField () ;Tname.setPrefSize(220, 30);
          Button cancel = new Button ("Cancel Reserve") ;
          v.addRow( 0 , Title  );

          v.addRow( 2,numberFlight ,Tnumber  );
          v.addRow( 3,namePassanger ,Tname  );
          v.addRow( 4,cancel  );
          Scene s2 = new Scene (v , 680 , 350) ;
          s.setScene(s2) ;
          s.show();
          cancel.setStyle("-fx-background-color:#FF6B92;  -fx-font-size:20;\n");
          cancel.setOnMouseEntered(e1->{
        	  cancel.setStyle("-fx-background-color:#69FFFF;-fx-font-size:20;\n");
  		});
          
          cancel.setOnMouseExited(e2->{
        	  cancel.setStyle("-fx-background-color:#FF6B92;  -fx-font-size:20;\n"
  					+ "\n");}
          );
          cancel.setOnAction(e2->{
        	Node n =  list.search(Integer.parseInt(Tnumber.getText())); // search a flight by id flight to search passanger in this flight and then remove it
        	if (n==null) {// if n equal null , this mean the flight doesnot exist in system
        		MessageError.MessageNotExistFlight(); // show message
        	}
        	else {
                n.remove(Tname.getText()) ;  // if flight exist , send name of passanger for this method to search it , if existed then romove it
                

        	}
             	 
          });
        
		});
		checkTicket.setOnAction(e->{// to check particular ticket if reserved or not
			  Stage s = new Stage () ;
	          GridPane  v = new GridPane();
	          Label Title = new Label ("        Check Tickiet        ") ;
	  		Title.setFont(new Font (40));
	  		Title.setAlignment(Pos.CENTER) ;
	  		Title.setStyle("-fx-background-color:#0CBF83;\n" + "-fx-background-radius:40;\n ");
	          v.setAlignment (Pos.CENTER) ;
	          v.setVgap(10);          v.setHgap(10);
	          Label numberFlight = new Label ("Number of Flight : ") ;
	          numberFlight.setFont(new Font(20));

	          Label namePassanger = new Label ("Name of Passanger : ") ;
	          namePassanger.setFont(new Font(20));

	          TextField Tnumber = new TextField () ;		Tnumber.setPrefSize(220, 30);

	          TextField Tname = new TextField () ;		Tname.setPrefSize(220, 30);

	          Button check = new Button ("Ckeck Reserve") ;
	          check.setStyle("-fx-background-color:#03BD16;  -fx-font-size:20;\n");
	          check.setOnMouseEntered(e1->{
	        	  check.setStyle("-fx-background-color:#FF6B92;-fx-font-size:20;\n");
	  		});
	          
	          check.setOnMouseExited(e2->{
	        	  check.setStyle("-fx-background-color:#03BD16;  -fx-font-size:20;\n"
	  					+ "\n");});
	          v.addRow( 0,Title );

	          v.addRow( 2,numberFlight ,Tnumber  );
	          v.addRow( 3,namePassanger ,Tname  );
	          v.addRow( 5,check  );
	          Scene s2 = new Scene (v , 640 , 300) ;
	          s.setScene(s2) ;
	          s.show();
	          check.setOnAction(e2->{
	        	  // search a flight to know exist or not 
	          	Node n =  list.search(Integer.parseInt(Tnumber.getText()));
	          	if (n==null) {
	          		// this mean flight not exist and show message error
	        		MessageError.MessageNotExistFlight();

	          	}
	          	else {
	          		// this mean flight exist and send name of passanger to search in this flight , 
	          		n.checkTicket(Tname.getText())  ;
	          		
	          	}
	          });
		});
		reportFlight.setOnAction(e->{// show information about all flight in file
			Main.list.reportFlight() ;
		}) ;
		reportPassanger.setOnAction(e->{// show information about all Passanger in file
			Main.list.reportPassanger();
		}) ;
		saveFilesFlight.setOnAction(e->{ // to save flight data  in file , even  reading in onother time
			list.saveToFileFlight();
		}) ;
		saveFilesPassanger.setOnAction(e->{// to save passanger data  in file , even  reading in onother time
			list.saveToFilePassanger();
		});
		Search.setOnAction(e->{ // search  all  passanger  that have same name 
			   Main.stage.getScene().setRoot(new SearchPassanger()) ;
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

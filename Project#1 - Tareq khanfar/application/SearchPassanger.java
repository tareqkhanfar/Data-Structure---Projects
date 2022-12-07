package application;


import PROJECT.Node;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SearchPassanger extends BorderPane{
public SearchPassanger () {
	Label name = new Label ("Name of Passanger :");
	TextField Tname = new TextField () ;
	Button search = new Button ("Search") ;
	Button Home = new Button ("Home") ;

	HBox h = new HBox(20) ;
	h.setPadding(new Insets(10));
	Home.setTranslateX(900);
	h.getChildren().addAll(name , Tname , search ,Home );
	TextArea infoPassanger = new TextArea () ;
	setTop(h);
	setCenter(infoPassanger);
	
	search.setOnAction(e->{
		if (Tname.getText() == "" || Tname.getText() == null ) {
			MessageError.MessageWarningEmptyData();
		}
		else {
			// get all   all  passengers  that have same name in all flight, display all information in textArea
			infoPassanger.setText(Main.list.searchPassanger(Tname.getText())) ;
		}
		 
	});
	Home.setOnAction(e->{
		   Main.stage.getScene().setRoot(Main.root) ;

	});
} 
}

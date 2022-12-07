package application;
	

import Code.InfixToPostfix;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
     VBox root = new VBox (5) ;
		root.setStyle("	-fx-background-color: linear-gradient(to bottom right, #FF7F58, #6A5ACD);" );

    // root.setAlignment(Pos.CENTER);
     root.setPadding(new Insets (10));
     TextField exp=new TextField () ;

     exp.setPrefSize(500, 80);
     exp.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;"+"-fx-background-radius:15");
     exp.setFont(new Font(30));
     
     TextField post=new TextField () ;
     post.setPrefSize(500, 80);         post.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;"+"-fx-background-radius:15");

     post.setFont(new Font(30));


     TextField result=new TextField () ;// ;result.setStyle("-fx-background-color:#736f6f;\n");
     result.setPrefSize(20, 60);     result.setStyle("-fx-background-color: #00000025;\r\n" + "   -fx-text-fill: white;"+"-fx-background-radius:15");
     result.setFont(new Font(30));
     result.setText("0");

Button sin = new Button ("Sin");sin.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15");
sin.setPrefSize(60,50);
sin.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
sin.setTextFill(Color.WHITE);

Button cos = new Button ("Cos");cos.setPrefSize(60,50);cos.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15");
cos.setTextFill(Color.WHITE);
cos.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
cos.setTextFill(Color.WHITE);
Button tan = new Button ("Tan");
tan.setPrefSize(60,50);
tan.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15");
tan.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
tan.setTextFill(Color.WHITE);
Button open = new Button ("(");open.setPrefSize(60,50);
open.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15");
open.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
open.setTextFill(Color.WHITE);open.setOnAction(e->{
	exp.appendText("(");
}) ;

Button close = new Button (")");close.setPrefSize(60,50);
close.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
close.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
close.setTextFill(Color.WHITE);
close.setOnAction(e->{
	exp.appendText(")");
}) ;
Button exclamation = new Button ("!");exclamation.setPrefSize(60,50);
exclamation.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
exclamation.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
exclamation.setTextFill(Color.WHITE);
Button off = new Button ("OFF");off.setPrefSize(60,50) ;
off.setOnAction(e->{
	System.exit(0) ;
});
off.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
off.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
off.setTextFill(Color.WHITE);
Button PI = new Button ("PI"); PI.setPrefSize(60,50);
PI.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
PI.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
PI.setTextFill(Color.WHITE);
Button y_x = new Button ("Y^X");y_x.setPrefSize(60,50);
y_x.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
y_x.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
y_x.setTextFill(Color.WHITE);
Button x_2 = new Button ("X^2");x_2.setPrefSize(60,50);
x_2.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
x_2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
x_2.setTextFill(Color.WHITE);
Button sqrt = new Button ();sqrt.setPrefSize(60,50);
Image imgSqrt = new Image(getClass().getResourceAsStream("sqrt.png"), 30, 30, false, false);
ImageView iconSqrt = new ImageView(imgSqrt);
sqrt.setGraphic(iconSqrt);
sqrt.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
sqrt.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
sqrt.setTextFill(Color.WHITE);
Button e_x = new Button ("e^x");e_x.setPrefSize(60,50);
e_x.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
e_x.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
e_x.setTextFill(Color.WHITE);
Button ln = new Button ("LN");ln.setPrefSize(60,50);
ln.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
ln.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
ln.setTextFill(Color.WHITE);
Button log = new Button ("LOG");log.setPrefSize(60,50);
log.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
log.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
log.setTextFill(Color.WHITE);
Button one_x = new Button ("1/x");one_x.setPrefSize(60,50);
one_x.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
one_x.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
one_x.setTextFill(Color.WHITE);
Button zero = new Button ("0");zero.setPrefSize(60,50);
zero.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
zero.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
zero.setTextFill(Color.WHITE);
Button one = new Button ("1");one.setPrefSize(60,50);
one.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
one.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
one.setTextFill(Color.WHITE);
Button two = new Button ("2");two.setPrefSize(60,50);
two.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
two.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
two.setTextFill(Color.WHITE);
Button three = new Button ("3");three.setPrefSize(60,50);
three.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
three.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
three.setTextFill(Color.WHITE);
Button four = new Button ("4");four.setPrefSize(60,50);
four.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
four.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
four.setTextFill(Color.WHITE);
Button five = new Button ("5");five.setPrefSize(60,50);
five.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
five.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
five.setTextFill(Color.WHITE);
Button six = new Button ("6");six.setPrefSize(60,50);
six.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
six.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
six.setTextFill(Color.WHITE);
Button seven = new Button ("7");seven.setPrefSize(60,50);
seven.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
seven.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
seven.setTextFill(Color.WHITE);
Button eight = new Button ("8");eight.setPrefSize(60,50);
eight.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
eight.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
eight.setTextFill(Color.WHITE);
Button nine = new Button ("9");nine.setPrefSize(60,50);
nine.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
nine.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
nine.setTextFill(Color.WHITE);
Button plus = new Button ("+");plus.setPrefSize(60,50);
plus.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
plus.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
plus.setTextFill(Color.WHITE);
Button minus = new Button ("-");minus.setPrefSize(60,50);
minus.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
minus.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
minus.setTextFill(Color.WHITE);
Button div = new Button ("/");div.setPrefSize(60,50);
div.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
div.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
div.setTextFill(Color.WHITE);
Button mul = new Button ("*");mul.setPrefSize(60,50);
mul.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
mul.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
mul.setTextFill(Color.WHITE);
Button mod = new Button ("%");mod.setPrefSize(60,50);
mod.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
mod.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
mod.setTextFill(Color.WHITE);
Button point = new Button (".");point.setPrefSize(60,50);
point.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
point.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
point.setTextFill(Color.WHITE);
Button neg = new Button ("(-)");neg.setPrefSize(60,50);
neg.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
neg.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
neg.setTextFill(Color.WHITE);
Button ca = new Button ("CA");ca.setPrefSize(60,50);
ca.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
ca.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
ca.setTextFill(Color.WHITE);
Button c = new Button ("C");c.setPrefSize(60,50);
c.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
c.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
c.setTextFill(Color.WHITE);
Button back = new Button ();back.setPrefSize(60,50);
Image imgBack = new Image(getClass().getResourceAsStream("back.png"), 30, 30, false, false);
ImageView iconBack = new ImageView(imgBack);
back.setGraphic(iconBack);
back.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
back.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
back.setTextFill(Color.WHITE);
Button find = new Button ("=");find.setPrefSize(500 , 80);
find.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );
find.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
find.setTextFill(Color.WHITE);

GridPane root2 = new GridPane () ;
root2.setAlignment(Pos.CENTER);
root2.setVgap(10) ;
root2.setHgap(10);
HBox h1 = new HBox (10) ;
HBox h2 = new HBox (10) ;
HBox h3 = new HBox (10) ;
HBox h4 = new HBox (10) ;
HBox h5 = new HBox (10) ;
HBox h6 = new HBox () ;

h1.getChildren().addAll( sin , cos , tan  , open , close , exclamation , off) ;
h2.getChildren().addAll(  PI , y_x , seven , eight , nine , div , neg );
h3.getChildren().addAll( x_2 , sqrt , four , five , six , mul , ca);
h4.getChildren().addAll(  e_x , ln ,one , two , three , minus , c);
h5.getChildren().addAll(  log , one_x , zero , point  ,mod , plus , back) ;
h6.getChildren().addAll( find) ;
root.getChildren().addAll(exp , post ,result , h1, h2 , h3 , h4 , h5 , h6) ;
Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calculator");
			primaryStage.show();
		
		// ############## action  ###########################
			zero.setOnAction(e->{
				exp.appendText("0");
			}) ;
			one.setOnAction(e->{
				exp.appendText("1");
			}) ;
			two.setOnAction(e->{
				exp.appendText("2");
			}) ;three.setOnAction(e->{
				exp.appendText("3");
			}) ;four.setOnAction(e->{
				exp.appendText("4");
			}) ;five.setOnAction(e->{
				exp.appendText("5");
			}) ;six.setOnAction(e->{
				exp.appendText("6");
			}) ;seven.setOnAction(e->{
				exp.appendText("7");
			}) ;eight.setOnAction(e->{
				exp.appendText("8");
			}) ;nine.setOnAction(e->{
				exp.appendText("9");
			}) ;point.setOnAction(e->{
				exp.appendText(".");
			}) ;
			plus.setOnAction(e->{
				exp.appendText("+");
			}) ;minus.setOnAction(e->{
				exp.appendText("-");
			}) ;div.setOnAction(e->{
				exp.appendText("/");
			}) ;mul.setOnAction(e->{
				exp.appendText("*");
			}) ;
			mod.setOnAction(e->{
				exp.appendText("%");
			}) ;
		back.setOnAction(e->{

			if (exp.getLength() != 0) {
				String s  = exp.getText().substring(0 , exp.getLength()-1) ;

	               exp.setText(s); 	
			}
					
		});

		find.setOnAction(e->{

			if (!InfixToPostfix.balanced(exp.getText().trim())) {
				post.setText("");
				result.setText("Missing Parentheses");
			}
			else {
				try {
				if (exp.getText().contains("ln(")) {
					double number = Double.parseDouble(exp.getText().substring(3, exp.getLength()-1));
					result.setText(Math.log10(number)+"");
				}
				else if (exp.getText().contains("log(")) {
					double number = Double.parseDouble(exp.getText().substring(4, exp.getLength()-1));
					result.setText(Math.log(number)+"");
				}
				else if (exp.getText().contains("sqrt(")) {
					double number = Double.parseDouble(exp.getText().substring(5, exp.getLength()-1));
					result.setText(Math.sqrt(number)+"");
				}
				else if (exp.getText().contains("sin(")) {
					double number = Double.parseDouble(exp.getText().substring(4, exp.getLength()-1));
					number = Math.toRadians(number);
					result.setText(Math.sin(number)+"");
				}
				else if (exp.getText().contains("cos(")) {
					double number = Double.parseDouble(exp.getText().substring(4, exp.getLength()-1));
					number = Math.toRadians(number);

					result.setText(Math.cos(number)+"");
				}
				else if (exp.getText().contains("tan(")) {
					double number = Double.parseDouble(exp.getText().substring(4, exp.getLength()-1));
					number = Math.toRadians(number);

					result.setText(Math.tan(number)+"");
				}
				else if (exp.getText().contains("--")) {
					int number = Integer.parseInt(exp.getText().replace("--", ""))*-1;
					result.setText(Math.negateExact(number)+"");
				}
				else {
						
				String  text = exp.getText().replaceAll("e", "2.718") ;

				String sFormat = InfixToPostfix.format(text);
				
				System.out.println("Format = "+sFormat);
				String afterFormat [] =  InfixToPostfix.toArrayString(sFormat);
				String postfix = InfixToPostfix.infixToPostfix(afterFormat);
				post.setText(postfix.replaceAll(",", " , "));
				String r = InfixToPostfix.evaluation(postfix.split(","))+"";
				result.setText(r) ;
				
					
					
				}
			}
				catch (Exception ex) {
					post.setText("");
					result.setText("Syntax Error");

				}
			}
		
		});
		c.setOnAction(e2->{
			String format[] = InfixToPostfix.format(exp.getText()).split(",");
			String s = "" ;
			for (int i = 0 ;i < format.length -1 ; i++) {
				s += format[i] ;
			}
			exp.setText(s);
		});
		y_x.setOnAction(e->{
			exp.appendText("^");
		});
		PI.setOnAction(e->{
			exp.appendText(Math.PI+"");
		});
		
		e_x.setOnAction(e->{
			exp.appendText("e^");
		});
		sqrt.setOnAction(e->{
			exp.appendText("sqrt(");
		});
		x_2.setOnAction(e->{
			exp.appendText("^2");
		});
		exclamation.setOnAction(e->{
			exp.appendText("!");

		});
		one_x.setOnAction(e->{
			exp.appendText("1/");

		});
		ln.setOnAction(e->{
			exp.appendText("ln(");
		});
		log.setOnAction(e->{
			exp.appendText("log(");

		});
		sin.setOnAction(e->{
			exp.appendText("sin(");

		});cos.setOnAction(e->{
			exp.appendText("cos(");

		});
		tan.setOnAction(e->{
			exp.appendText("tan(");

		});
		ca.setOnAction(e->{
			exp.setText("");
			post.setText("");
			result.setText("0");
		});
		neg.setOnAction(e->{
			exp.appendText("-");

		});
		
		
		// #########################   Mouse Actions #########################################

		
		zero.setOnMouseEntered(e->{
			zero.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		zero.setOnMouseExited(e->{
			zero.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		one.setOnMouseEntered(e->{
			one.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		one.setOnMouseExited(e->{
			one.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});two.setOnMouseEntered(e->{
			two.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		two.setOnMouseExited(e->{
			two.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});three.setOnMouseEntered(e->{
			three.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		three.setOnMouseExited(e->{
			three.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});four.setOnMouseEntered(e->{
			four.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		four.setOnMouseExited(e->{
			four.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});five.setOnMouseEntered(e->{
			five.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		five.setOnMouseExited(e->{
			five.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});six.setOnMouseEntered(e->{
			six.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		six.setOnMouseExited(e->{
			six.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});seven.setOnMouseEntered(e->{
			seven.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		seven.setOnMouseExited(e->{
			seven.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});eight.setOnMouseEntered(e->{
			eight.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		eight.setOnMouseExited(e->{
			eight.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});nine.setOnMouseEntered(e->{
			nine.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		nine.setOnMouseExited(e->{
			nine.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});point.setOnMouseEntered(e->{
			point.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		point.setOnMouseExited(e->{
			point.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		sqrt.setOnMouseEntered(e->{
			sqrt.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		sqrt.setOnMouseExited(e->{
			sqrt.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		sin.setOnMouseEntered(e->{
			sin.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		sin.setOnMouseExited(e->{
			sin.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		cos.setOnMouseEntered(e->{
			cos.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		cos.setOnMouseExited(e->{
			cos.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		tan.setOnMouseEntered(e->{
			tan.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		tan.setOnMouseExited(e->{
			tan.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		exclamation.setOnMouseEntered(e->{
			exclamation.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		exclamation.setOnMouseExited(e->{
			exclamation.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		off.setOnMouseEntered(e->{
			off.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		off.setOnMouseExited(e->{
			off.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		open.setOnMouseEntered(e->{
			open.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		open.setOnMouseExited(e->{
			open.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		close.setOnMouseEntered(e->{
			close.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		close.setOnMouseExited(e->{
			close.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		
		x_2.setOnMouseEntered(e->{
			x_2.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		x_2.setOnMouseExited(e->{
			x_2.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		y_x.setOnMouseEntered(e->{
			y_x.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		y_x.setOnMouseExited(e->{
			y_x.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		
		ln.setOnMouseEntered(e->{
			ln.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		ln.setOnMouseExited(e->{
			ln.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		
		log.setOnMouseEntered(e->{
			log.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		log.setOnMouseExited(e->{
			log.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		
		e_x.setOnMouseEntered(e->{
			e_x.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		e_x.setOnMouseExited(e->{
			e_x.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		one_x.setOnMouseEntered(e->{
			one_x.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		one_x.setOnMouseExited(e->{
			one_x.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		PI.setOnMouseEntered(e->{
			PI.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		PI.setOnMouseExited(e->{
			PI.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		plus.setOnMouseEntered(e->{
			plus.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		plus.setOnMouseExited(e->{
			plus.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		minus.setOnMouseEntered(e->{
			minus.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		minus.setOnMouseExited(e->{
			minus.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		mul.setOnMouseEntered(e->{
			mul.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		mul.setOnMouseExited(e->{
			mul.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		div.setOnMouseEntered(e->{
			div.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		div.setOnMouseExited(e->{
			div.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		mod.setOnMouseEntered(e->{
			mod.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		mod.setOnMouseExited(e->{
			mod.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		c.setOnMouseEntered(e->{
			c.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		c.setOnMouseExited(e->{
			c.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		ca.setOnMouseEntered(e->{
			ca.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		ca.setOnMouseExited(e->{
			ca.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		back.setOnMouseEntered(e->{
			back.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		back.setOnMouseExited(e->{
			back.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		
		neg.setOnMouseEntered(e->{
			neg.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		neg.setOnMouseExited(e->{
			neg.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
		
		
		find.setOnMouseEntered(e->{
			find.setStyle("-fx-background-color:#c1b3b4;\n"+"-fx-background-radius:15" );

		});
		find.setOnMouseExited(e->{
			find.setStyle("-fx-background-color:#00000025;\n"+"-fx-background-radius:15" );

		});
	}
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

module ProjectThree {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.base;
	
	opens application to javafx.graphics, javafx.fxml;
}

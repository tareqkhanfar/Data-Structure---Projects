package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageError {

	public MessageError() {
		// TODO Auto-generated constructor stub
	}

	public static void MessageWarningEmptyData() {
		Alert Empty = new Alert(AlertType.WARNING);
		Empty.setContentText("One of the fields is empty.\n Please fill in all fields");
		Empty.showAndWait();
	}

	public static void MessageWarningNotSelectDep() {
		Alert Empty = new Alert(AlertType.WARNING);
		Empty.setContentText("MessageWarningNotSelectDep");
		Empty.showAndWait();
	}

	public static void selectCorrectFile(String correct) {
		Alert Empty = new Alert(AlertType.ERROR);

		Empty.setContentText("Please Select Correct File !! " + "\n Correct File : " + correct);

		Empty.showAndWait();
	}

	public static void MessageErrorFlight() {
		Alert Empty = new Alert(AlertType.ERROR);

		Empty.setContentText("this Dep already exist in data base");
		Empty.showAndWait();
	}

	public static void MessageNotExistDep() {
		Alert Empty = new Alert(AlertType.WARNING);
		Empty.setContentText("this Dep DOES NOT  exist in data base");
		Empty.showAndWait();
	}

	public static void MessageNotExistStudent() {
		Alert Empty = new Alert(AlertType.WARNING);

		Empty.setContentText("this Student DOES NOT  exist in data base");
		Empty.showAndWait();
	}

	public static void MessageErrorPassanger() {
		Alert Empty = new Alert(AlertType.ERROR);

		Empty.setContentText("this Student already exist in data base");
		Empty.showAndWait();
	}

	public static void MessageAddDepartment() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This Department has been successfully added");
		Empty.showAndWait();
	}

	public static void MessageDeleteDep() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This Departmrnt has been successfully deleted");
		Empty.showAndWait();
	}

	public static void MessageAddStudent() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This Student has been successfully added");
		Empty.showAndWait();
	}

	public static void MessageDeleteStudent() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This Student has been successfully deleted");
		Empty.showAndWait();
	}

	public static void MessageSaveData() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("Data saved successfully");
		Empty.showAndWait();
	}

}

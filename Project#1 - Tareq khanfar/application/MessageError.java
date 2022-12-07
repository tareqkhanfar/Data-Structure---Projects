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
	public static void EmptyCapacity(int x , String name) {
		Alert Empty = new Alert(AlertType.ERROR);

		Empty.setContentText("Flight Number : " + x + "Airline : " + name + "\n CAPACITY IS EMPTY !! ");
		
		Empty.showAndWait();
	}

	public static void MessageErrorFlight() {
		Alert Empty = new Alert(AlertType.ERROR);

		Empty.setContentText("this Flight already exist in data base");
		Empty.showAndWait();
	}

	public static void MessageNotExistFlight() {
		Alert Empty = new Alert(AlertType.WARNING);
		Empty.setContentText("this Flight DOES NOT  exist in data base");
		Empty.showAndWait();
	}

	public static void MessageNotExistPassanger() {
		Alert Empty = new Alert(AlertType.WARNING);

		Empty.setContentText("this Passanger DOES NOT  exist in data base");
		Empty.showAndWait();
	}

	public static void MessageErrorPassanger() {
		Alert Empty = new Alert(AlertType.ERROR);

		Empty.setContentText("this Passanger already exist in data base");
		Empty.showAndWait();
	}

	public static void MessageAddFlight() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This Flight has been successfully added");
		Empty.showAndWait();
	}

	public static void MessageDeleteFlight() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This Flight has been successfully deleted");
		Empty.showAndWait();
	}

	public static void MessageAddPassanger() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This Passanger has been successfully added");
		Empty.showAndWait();
	}

	public static void MessageDeletePassanger() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("This Passanger has been successfully deleted");
		Empty.showAndWait();
	}

	public static void MessageSaveData() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("Data saved successfully");
		Empty.showAndWait();
	}
	public static void TickitExist() {
		Alert Empty = new Alert(AlertType.INFORMATION);

		Empty.setContentText("Tickit is Reserved ");
		Empty.showAndWait();
	}
	public static void TickitNotExist() {
		Alert Empty = new Alert(AlertType.WARNING);

		Empty.setContentText("Tickit is NOT Reserved ");
		Empty.showAndWait();
	}
}

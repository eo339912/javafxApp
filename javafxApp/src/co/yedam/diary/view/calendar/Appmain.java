package co.yedam.diary.view.calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Appmain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("calendar.fxml"));
		Scene scene = new Scene(root, 300, 300);
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}

}

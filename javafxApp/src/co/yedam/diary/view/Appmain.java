package co.yedam.diary.view;

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
		Parent root = FXMLLoader.load(getClass().getResource("diaryList.fxml"));
		Scene scene = new Scene(root, 600, 430);
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}

}

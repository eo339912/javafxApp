package co.yedam.diary.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import co.yedam.diary.model.DiaryDAO;
import co.yedam.diary.model.DiaryDO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InputContraller implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	DatePicker txtDate;

	@FXML
	TextField txtTitle;

	@FXML
	TextArea txtContents;

	@FXML
	TextField txtWeather;
	@FXML
	BorderPane rootLayout;
	@FXML
	Button btnList;
	@FXML
	Button btnHome;
	@FXML
	HBox hbox;

	@FXML // 저장버튼 click
	public void dyInsert(ActionEvent actionEvent) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("저장 메시지");
		alert.setHeaderText("일기를 저장하려합니다.");
		alert.setContentText("정말 저장하시겠습니까?");

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == ButtonType.OK) {

			LocalDate localDate = txtDate.getValue();
			String strDate = "";
			if (localDate != null) {
				strDate = localDate.toString();
			}
			// DAO
			// 텍스트 필드값을 읽어서 DO 객체 담기
			DiaryDO dy = new DiaryDO();

			dy.setdDate(strDate);
			dy.setTitle(txtTitle.getText());
			dy.setContents(txtContents.getText());
			dy.setWeather(txtWeather.getText());

			// DAO 등록
			DiaryDAO dao = new DiaryDAO();
			dao.insert(dy);
			System.out.println("저장처리됨");
			
			//수정하고 리스트로 넘어가기
			goList();
		}
	}

	@FXML // 취소버튼 click -> 리스트로
	public void dyDelete(ActionEvent actionEvent) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("취소 메시지");
		alert.setHeaderText("리스트 화면으로 돌아갑니다.");
		alert.setContentText("정말 취소하시겠습니까?");

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == ButtonType.OK) {
		goList();
		
		}
	} //E of dyDelete

	@FXML
	public void goList(ActionEvent event) {
		goList();
	}
	
	
	public void goHome(ActionEvent event) {
		try {
			Stage stage = new Stage();

			Parent root = FXMLLoader.load(getClass().getResource("/co/yedam/diary/view/calendar/calendar.fxml"));
			Scene scene = new Scene(root, 600, 430);
			stage.setScene(scene);
			stage.show();

			// 메인 창 닫아주기
			Stage main = (Stage) rootLayout.getScene().getWindow();
			main.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//리스트 가는 매소드
	public void goList() {
		try {
			BorderPane diaryListView = FXMLLoader.load(getClass().getResource("diaryList.fxml"));

			Scene scene = new Scene(diaryListView);

			Stage window = new Stage();
			window.setScene(scene);

			// make window visible
			window.show();
          
			// 메인 창 닫아주기
			Stage main = (Stage) rootLayout.getScene().getWindow();
			main.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

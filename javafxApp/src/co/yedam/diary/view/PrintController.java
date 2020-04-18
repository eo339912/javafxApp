package co.yedam.diary.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.yedam.diary.model.DiaryDAO;
import co.yedam.diary.model.DiaryDO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class PrintController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	@FXML
	TextField txtDate;
	
	@FXML
	TextField txtTitle;
	
	@FXML
	TextField txtContents;
	
	@FXML
	TextField txtWeather;
	
	@FXML //수정버튼 click
	public void dyChange(ActionEvent actionEvent) {
		DiaryDO dy = new DiaryDO();
		//dy.setIdx(txtIdx.getInt());
		
		DiaryDAO dao = new DiaryDAO();
		DiaryDO result = dao.select(dy);
		
		txtDate.setText(result.getdDate());
		txtTitle.setText(result.getTitle());
		txtWeather.setText(result.getWeather());
		txtContents.setText(result.getContents());
		System.out.println("수정처리됨");
		

	}
	
	@FXML //삭제버튼 click
	public void dyDelete(ActionEvent actionEvent) {
		System.out.println("삭제처리됨");
	}
	
	
}

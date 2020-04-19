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

	@FXML
	TextField txtIdx;
	
	@FXML
	TextField txtDate;
	
	@FXML
	TextField txtTitle;
	
	@FXML
	TextField txtContents;
	
	@FXML
	TextField txtWeather;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DiaryDO dy = new DiaryDO();
		for(String item: DataModel.num) {
			dy.setIdx(item);
//			txtIdx.setText(item);
        }
		
		DiaryDAO dao = new DiaryDAO();
		DiaryDO result = dao.select(dy);
		
//		txtIdx.setText(result.getIdx());
		txtDate.setText(result.getdDate());
		txtTitle.setText(result.getTitle());
		txtWeather.setText(result.getWeather());
		txtContents.setText(result.getContents());
		
	}
	
	@FXML //수정버튼 click
	public void dyChange(ActionEvent actionEvent) {
		
		System.out.println("수정처리됨");
	}
	
	@FXML //삭제버튼 click
	public void dyDelete(ActionEvent actionEvent) {
		
		//죄회할 사번을 DO객체에 담기
		DiaryDO dy = new DiaryDO();
		dy.setdDate(txtDate.getText());
				
		//단건조회
		DiaryDAO dao = new DiaryDAO();
		DiaryDO result = dao.delete(dy);;
				
		System.out.println("삭제처리됨");
	}
	
	
}

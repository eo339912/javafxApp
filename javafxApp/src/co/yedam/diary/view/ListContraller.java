package co.yedam.diary.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.yedam.diary.model.DiaryDAO;
import co.yedam.diary.model.DiaryDO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class ListContraller implements Initializable{
	
	@FXML
	private ListView<DiaryDO> listView;
	@FXML
	private BorderPane rootLayout;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(FXCollections.observableArrayList());
		
		DiaryDAO d = new DiaryDAO();
		List<DiaryDO> dlist = d.getDiaryList();
				
		for(DiaryDO by : dlist) {
			listView.getItems().add(by);		
		}
		
		listView.setOnMouseClicked((MouseEvent)->{
           Object obj = listView.getSelectionModel().getSelectedItem();
           listView.getItems();
            
            try {
                Parent sub = FXMLLoader.load(getClass().getResource("../view/diaryPrint.fxml")); // 서브페이지 불러오고
                // 메인창 지정 -> 씬 불러오기 -> 레이아웃 불러오기
                //BorderPane root = (BorderPane) rootLayout.getScene().getRoot();
                //Stage primaryStage = (Stage) menubar.getScene().getWindow();
                // 서브페이지 추가 (메인 레이아웃을 서브 레이아웃이 덮어쓴다.)
                //root.getChildren().add(sub);
                
    			rootLayout.setCenter(sub);
    			
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
		
	}
	
	

	
	
}

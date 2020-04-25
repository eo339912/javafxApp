package co.yedam.diary.view.calendar;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import co.yedam.diary.view.DataModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneNode extends GridPane{

    private LocalDate date;

	public GridPaneNode(Node... children) {
      super();
      this.setOnMouseClicked(//e -> System.out.println("This pane's date is: " + date)
    		  
    		  (MouseEvent) -> {
    				try {
    					checkValue();
    					// 새로운 창 띄우기 (새 스테이지 생성 -> 씬 추가 -> 레이아웃 추가)
    					Stage stage = new Stage();
    					Parent root = FXMLLoader.load(getClass().getResource("../../view/diaryPrint.fxml"));
    					Scene sc = new Scene(root);
    					stage.setScene(sc);
    					stage.show();

    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    			}
    		  
    		  
     );
	}
	
  public LocalDate getDate() {
	  return date;
  }

  public void setDate(LocalDate date) {
	  this.date = date;
  }
    
    

	private void checkValue() {
	    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String strDate = formatter.format(date);
        DataModel.inDate.add(strDate);
        
        System.out.println(date);


	}
	
}

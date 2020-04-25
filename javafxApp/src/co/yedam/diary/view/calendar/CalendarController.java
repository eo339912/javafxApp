package co.yedam.diary.view.calendar;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalendarController implements Initializable {

	@FXML
	Button btnLeft;
	
	@FXML
	Button btnRight;
	
	@FXML
	Label yearTop;
	
	@FXML
	GridPane calDate;
	
	@FXML
	GridPane calDay;
	
	ArrayList<GridPaneNode> allCalendarDays = new ArrayList<>(35);
	
	Calendar cal = Calendar.getInstance(); 
	Date date = cal.getTime(); 
	int year = cal.get(Calendar.YEAR); 
	int month = cal.get(Calendar.MONTH);
	int day = cal.get(Calendar.DATE);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		date();
		
	} // end of initialize
	
	@FXML // next버튼 click
	public void leftClick(ActionEvent actionEvent) {
		calDate.getChildren().remove(1, calDate.getChildren().size());  
		
		if(month <= 0) {
			month = 12;
			--year;
		};
		
		--month;
		cal.set(year,month, day);
		date();
		
	}//end of leftClick
	
	@FXML // next버튼 click
	public void rightClick(ActionEvent actionEvent) {
		calDate.getChildren().remove(1, calDate.getChildren().size());  

		if(month >= 11) {
			month = 1;
			++year;
		};
		
		++month;
		cal.set(year,month, day);
		date();
	}//end of rightClick
	
	@FXML
	public void calInputView(ActionEvent event) {
		try {
			BorderPane diaryInputView = FXMLLoader.load(getClass().getResource("./src/view/diaryInput.fxml"));
			Scene scene = new Scene(diaryInputView);

			Stage window = new Stage();
			window.setScene(scene);

			// make window visible
			window.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end of calInputView
	
	public void date(){

		yearTop.setText(year + "년 " + (month + 1)+ "월");
		
		//cal.set(year,month, day); //해당월
		int totaldate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //해당월의 최대 일수 
		
		
		 
		cal.set(Calendar.DAY_OF_MONTH,1); //DAY_OF_MONTH를 1로 설정 (월의 첫날)
		int week = cal.get(Calendar.DAY_OF_WEEK); //그 주의 요일 반환 (일:1 ~ 토:7)
		
		Label[] a = new Label[35];
		int i = 0;
		int k = week-1;

		for(int j = 1; j < (totaldate+1); j++) {
			
			
			a[i] = new Label("" + j);
			
			GridPaneNode ap = new GridPaneNode();
			LocalDate calendarDate = LocalDate.of(year, month+1, j);
			ap.setDate(calendarDate);
			calDate.add(ap,k,i);
			allCalendarDays.add(ap);

			
			calDate.add(a[i], k, i);
			k++;
			if(k%7 ==0) {
				i++;
				k =0;
			}
			
		}		
		
		System.out.println("년월일" + year + "," + month + "," + day);
		System.out.println("week" + week);
		
	}//end of date
	
	
}

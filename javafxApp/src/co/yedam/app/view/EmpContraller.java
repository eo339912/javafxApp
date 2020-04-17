package co.yedam.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.yedam.app.medel.EmpDAO;
import co.yedam.app.medel.EmpDO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class EmpContraller implements Initializable{
	
	@FXML
	TextField txtEmployeeId;
	
	@FXML
	TextField txtLastName;
	
	@FXML
	TextField txtHireDate;
	
	@FXML
	TextField txtEmail;
	
	@FXML
	TextField txtJobId;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	@FXML //등록버튼 click
	public void empInsert(ActionEvent actionEvent) {
		//DAO
		//텍스트 필드값을 읽어서 DO 객체 담기
		EmpDO emp = new EmpDO();
		emp.setEmployeeId(txtEmployeeId.getText());
		emp.setLastName(txtLastName.getText());
		emp.setHireDate(txtHireDate.getText());
		emp.setEmail(txtEmail.getText());
		emp.setJobId(txtJobId.getText());
		
		//DAO 등록
		EmpDAO dao = new EmpDAO();
		dao.insert(emp);
		System.out.println("등록처리됨");
	}
	
	@FXML //수정버튼 click
	public void empUpdate(ActionEvent actionEvent) {
		System.out.println("수정처리됨");
	}
	
	@FXML //조회버튼 click
	public void empSelect(ActionEvent actionEvent) {
		//죄회할 사번을 DO객체에 담기
		EmpDO emp = new EmpDO();
		emp.setEmployeeId(txtEmployeeId.getText());
		
		//단건조회
		EmpDAO dao = new EmpDAO();
		EmpDO result = dao.selectOne(emp);
		
		//텍스트필드에 표시
		txtEmployeeId.setText(result.getEmployeeId());
		txtEmail.setText(result.getEmail());
		txtHireDate.setText(result.getHireDate());
		txtJobId.setText(result.getJobId());
		txtLastName.setText(result.getLastName());
		System.out.println("조회처리됨");
	}
	
}

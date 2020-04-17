package co.yedam.app.medel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAO {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = null;
	
	//등록
	public void insert(EmpDO emp) {		
		
		try {
			//1. DB connect (DB연결)
			conn = DriverManager.getConnection(url , "hr", "hr");
			
			//2. statement (SQL 구문준비)
			String sql = "insert into employees (employee_id, last_name, email, hire_date, job_id) "
					+ " values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3. execute
			pstmt.setString(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getHireDate());
			pstmt.setString(5, emp.getJobId());
			
			pstmt.executeUpdate(); //dml
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//4. 조회결과 (등록이라 필요없음)
			//5. close(연결해제)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//단건조회
	public EmpDO selectOne(EmpDO emp) {		
		EmpDO empDO = new EmpDO();
		try {
			//1. DB connect (DB연결)
			conn = DriverManager.getConnection(url , "hr", "hr");
			
			//2. statement (SQL 구문준비)
			String sql = "select * from employees where employee_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3. execute
			pstmt.setString(1, emp.getEmployeeId());
			ResultSet rs = pstmt.executeQuery();
			
			//4. 조회결과
			if(rs.next()) {
				empDO.setEmployeeId(rs.getString("employee_id"));
				empDO.setEmail(rs.getString("email"));
				empDO.setHireDate(rs.getString("hire_date"));
				empDO.setJobId(rs.getString("job_id"));
				empDO.setLastName(rs.getString("last_name"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. close(연결해제)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empDO;
		
	}

	//삭제
	public void delete(EmpDO emp) {		
		
		try {
			//1. DB connect (DB연결)
			conn = DriverManager.getConnection(url , "hr", "hr");
			
			//2. statement (SQL 구문준비)
			String sql = "delete from employees where employee_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3. execute
			pstmt.setString(1, emp.getEmployeeId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//4. 조회결과 (등록이라 필요없음)
			//5. close(연결해제)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	//조회
	
	//삭제
	
	//전체조회
}

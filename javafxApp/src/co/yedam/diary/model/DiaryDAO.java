package co.yedam.diary.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.DatePicker;

public class DiaryDAO {
	
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = null;
	
	
	//저장 -> 데이터 추가
	public void  insert(DiaryDO Dy) {		
		try {
			//1. DB connect (DB연결)
			conn = DriverManager.getConnection(url , "hr", "hr");

			
			//2. statement (SQL 구문준비)
			String sql = "insert into diary (idx, d_date,weather, title, contents) "
					+ " values((select nvl(max(idx),0)+1 from diary),?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3. execute
			//pstmt.setDate(1, getCurrentDate());
			pstmt.setString(1, Dy.getdDate());
			pstmt.setString(2, Dy.getWeather());
			pstmt.setString(3, Dy.getTitle());
			pstmt.setString(4, Dy.getContents());
			
			pstmt.executeUpdate();
			//4. 조회결과 (등록이라 필요없음)
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				//5. close(연결해제)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
//	static java.sql.Date getCurrentDate() {
//	    java.util.Date today = new java.util.Date();
//	    return new java.sql.Date(today.getTime());
//	}
}

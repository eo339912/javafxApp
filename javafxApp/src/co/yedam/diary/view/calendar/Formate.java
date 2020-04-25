package co.yedam.diary.view.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formate {
	public static void main(String[] args) {
	      //1. int -> String
	      int num = 10;
	      String str = Integer.toString(num);
	      System.out.println("16진수: " +Integer.toHexString(num)); //알파벳으로 출력
	      
	      //2.Doble -> String
	      double dnum = 4.15;
	      str = Double.toString(dnum);
	      System.out.println("double: " +str);
	      
	      //3.String -> int
	      String snum = "1010";
	      num = Integer.parseInt(snum);
	      System.out.println("int:" +snum);
	      
	      //4.String -> double
	      dnum = Double.parseDouble(snum);
	      System.out.println(dnum);
	      
	      //5. String ->Double (snum을 Double 객체에 담을것)
	      Double dobj = Double.parseDouble(snum); // double변환 -> 박싱
	      
	      // 6. 기본 double ->int
	      num = (int)dnum;
	         
	      // 7. 객체 Double --> int
	      num = dobj.intValue();
	      
	      //8. Date -> long int
	      Date today = new Date();
	      long todayNum = today.getTime();
	      System.out.println("todayNum: " +todayNum);
	      
	      //9. long -> Date
	      Date hireDate =  new Date(todayNum);
	      
	      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	      //10. Date -> string  // SimpleDateFormat: 날짜값을 스티링으로 바꿔쓰는 객체
	      String strDate = format.format(hireDate);
	      System.out.println("strDate: " +strDate);
	      
	      //11. String -> Date
	      SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd hh:mm");
	      String xmas = "2020/12/25 12:00";
	      
	      try {
	         hireDate = format2.parse(xmas);
	      } catch (ParseException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      System.out.println("xmas: " +xmas);
	}
}

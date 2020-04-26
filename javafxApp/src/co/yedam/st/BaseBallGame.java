package co.yedam.st;

import java.util.Scanner;

public class BaseBallGame {
	public static void main(String[] args) {
	      int com1, com2, com3, usr1, usr2, usr3, cnt, s, b;
	      Scanner scn = new Scanner(System.in);
	      usr1 = scn.nextInt();
	      usr2 = scn.nextInt();
	      usr3 = scn.nextInt();
	   }
	}

	//**야구게임 만들기**
	//
	//조건 : 10회 이상이면 게임오버
	//   10회 이내에 3s 이면 게임종료 
	//
	//변수 ; com1, com2, com3
//	       usr1, usr2, usr3
	//   cnt, s, b
	//
	//수도코드 :
	//   컴퓨터가 서로 다른 난수 3개 만듦 (같은 수 x)
	//   스트라익 0으로 초기화
	//   게임횟수 0으로 초기화
	//   스트라익이 3이거나 게임횟수 10  이상이면 게임 종료 아니면 반복
//	      스트라익, 볼을 0으로 초기화
//	      사용자 숫자 3개 입력
//	      같은자리에 같은 수가 있으면 스트라익 증가
//	      다른자리에 같은 수가 있으면 볼 증가
	//
	//   스트라익이 3이면 게임종료 출력하고 아니면 게임오버 출력
	//
	//if문으로 볼증가
	//
	//그리고 와일문으로 돌아가서 게임횟수 증가
	//게임횟수 10번 되면 빠져나오고
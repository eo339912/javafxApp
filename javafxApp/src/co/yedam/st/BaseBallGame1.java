package co.yedam.st;

import java.util.Scanner;

public class BaseBallGame1 {
	public static void main(String[] args) {
		int[] answer = new int[3];
		int[] answer2 = new int[3];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = (int) (Math.random() * 9) + 1;						
			System.out.print(answer[i]);
		}
		
		
		int cnt = 10;
		//System.out.println();
		
		Scanner scn = new Scanner(System.in);
		while(true) {
			
			for(int i = 0; i < answer2.length; i++) {
				answer2[i] = scn.nextInt();
			}
			
			for(int i = 0; i < answer2.length; i++) {
				System.out.print(answer2[i]);
			}
			System.out.println();
			
			
			int s = 0; 
			for(int i = 0; i < answer.length; i++) {
				if(answer[i] == answer2[i]) {
					s++;
				}
			}
			System.out.print(s + "strike" + ", ");
			
			int b = 0;
			for(int j = 0; j < answer.length; j++) {
				for(int i = 0; i < answer.length; i++) {
					if(answer[j] == answer2[i] && j != i) {
						b++;
					}
				}
			}
			System.out.println(b + "ball");
			
			if(s == 3) {
				System.out.println("Win");
				break;
			}
			
			cnt--;
			System.out.println(cnt + "번 남았습니다.");
			if(cnt == 0) {
				System.out.println("Lose");
				break;
			}
			
		}
		
	}
}

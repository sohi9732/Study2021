package Programmers.Level1;

import java.util.Scanner;

public class Level1_12969_직사각형별찍기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); //5
		int b = sc.nextInt(); //3
		
		for(int i = 0; i < b; i++) {
			for(int j = 0; j < a; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

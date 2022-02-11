package bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_10157_자리배정 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int R, C, K;
	static int [][] seats;
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(br.readLine());
		seats = new int [R][C];
		
		if(K > C * R) {
			System.out.println(0);
			return;
		}
		
		int num = 1;
		int r = R - 1, c = 0;
		int dir = 0; // 0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽
		while(num <= K) {
			seats[r][c] = num++;
			switch(dir) {
			case 0:
				if(r - 1 < 0 || seats[r - 1][c] > 0) {
					dir = 1;
					c++;
				} else {
					r--;
				}
				break;
			case 1:
				if(c + 1 == C || seats[r][c + 1] > 0) {
					dir = 2;
					r++;
				} else {
					c++;
				}
				break;
			case 2:
				if(r + 1 == R || seats[r + 1][c] > 0) {
					dir = 3;
					c--;
				} else {
					r++;
				}
				break;
			case 3:
				if(c - 1 < 0 || seats[r][c - 1] > 0) {
					dir = 0;
					r--;
				} else {
					c--;
				}
				break;
			}
		}
		switch(dir) {
		case 0:
			r++;
			break;
		case 1:
			c--;
			break;
		case 2:
			r--;
			break;
		case 3:
			c++;
			break;
		}
		
		System.out.println((c + 1) + " " + (R - r));
		
	}

}

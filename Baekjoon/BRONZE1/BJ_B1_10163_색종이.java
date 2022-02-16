package bj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B1_10163_색종이 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int [][] map = new int [1002][1002];
	static int [] cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(tokens.nextToken());
			int C = Integer.parseInt(tokens.nextToken());
			int h = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			
			// 색종이 덮기
			for(int r = R; r < R + h; r++) {
				for(int c = C; c < C + w; c++) {
					map[r][c] = i;
				}
			}
			
		}
		
		// 각각의 색종이 수 세기
		cnt = new int [N + 1];
		for(int r = 0; r < 1001; r++) { 
			for(int c = 0; c < 1001; c++) {
				cnt[map[r][c]]++;
			}
		}
		
		// 출력
		for(int i = 1; i <= N; i++) {
			output.append(cnt[i]).append("\n");
		}
		System.out.print(output);

	}

}

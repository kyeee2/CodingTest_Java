package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_16926_배열돌리기1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder outer = new StringBuilder();
	
	static int N, M;
	static Long R;
	static int [][] arr;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Long.parseLong(tokens.nextToken());
		arr = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int rs = 0, re = N - 1, cs = 0, ce = M - 1;
		while(rs < re && cs < ce) {
			int n = re - rs;
			int m = ce - cs;
			for(int i = 0; i < R % (2 * n + 2 * m); i++) {
				int temp = arr[rs][cs];
				// ← 방향
				for(int c = cs; c < ce; c++) {
					arr[rs][c] = arr[rs][c + 1];
				}
				// ↑ 방향
				for(int r = rs; r < re; r++) {
					arr[r][ce] = arr[r + 1][ce];
				}
				// → 방향
				for(int c = ce; c > cs; c--) {
					arr[re][c] = arr[re][c - 1];
				}
				// ↓ 방향
				for(int r = re; r > rs; r--) {
					arr[r][cs] = arr[r - 1][cs];
				}
				
				arr[rs + 1][cs] = temp;
			}			
			
			rs++;
			re--;
			cs++;
			ce--;
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(c > 0) outer.append(" ");
				outer.append(arr[r][c]);
			}
			outer.append('\n');
		}
		System.out.println(outer);
	}

}

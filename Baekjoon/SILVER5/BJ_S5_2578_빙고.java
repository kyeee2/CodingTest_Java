package bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S5_2578_빙고 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static Map<Integer, Point> map = new HashMap<>();
	static int [][] ch = new int [25][25]; // 0 : 아직 안부름, 1 : 부름, 2 : 빙고에 쓰임
	static int cnt; // 빙고 개수

	public static void main(String[] args) throws IOException {
		
		for(int r = 0; r < 5; r++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			for(int c = 0; c < 5; c++) {
				int n = Integer.parseInt(tokens.nextToken());
				map.put(n, new Point(r, c));
			}
		}
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				int n = Integer.parseInt(tokens.nextToken());
				
				Point p = map.get(n);
				ch[p.r][p.c] = 1;
				
				checkBingo(p.r, p.c);
				
				if(cnt >= 3) {
					System.out.println(i * 5 + j + 1);
					return;
				}
			}
		}

	}

	private static void checkBingo(int r, int c) {
		// 가로
		boolean flag = true;
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			if(ch[r][i] == 0) flag = false;
			sum += ch[r][i];
		}
		
		if(flag && sum != 10) {
			cnt++;
			for(int i = 0; i < 5; i++) {
				ch[r][i] = 2;
			}
		}
		
		// 세로
		flag = true;
		sum = 0;
		for(int i = 0; i < 5; i++) {
			if(ch[i][c] == 0) flag = false;
			sum += ch[i][c];
		}
		
		if(flag && sum != 10) {
			cnt++;
			for(int i = 0; i < 5; i++) {
				ch[i][c] = 2;
			}
		}
		
		if(r == c || r + c == 4) {
			// 오른쪽 대각선
			flag = true;
			sum = 0;
			for(int i = 0; i < 5; i++) {
				if(ch[i][4 - i] == 0) flag = false;
				sum += ch[i][4 - i];
			}
			
			if(flag && sum != 10) {
				cnt++;
				for(int i = 0; i < 5; i++) {
					ch[i][4 - i] = 2;
				}
			}
			
			// 왼쪽 대각선
			flag = true;
			sum = 0;
			for(int i = 0; i < 5; i++) {
				if(ch[i][i] == 0) flag = false;
				sum += ch[i][i];
			}
			
			if(flag && sum != 10) {
				cnt++;
				for(int i = 0; i < 5; i++) {
					ch[i][i] = 2;
				}
			}
			
		}
	}

}

class Point {
	int r, c;
	
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

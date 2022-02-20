package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_7576_토마토 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static int [][] tomatos;
	static Queue<Point> Q = new LinkedList<>();
	static int [] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		
		tomatos = new int [N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				tomatos[r][c] = Integer.parseInt(tokens.nextToken());
				if(tomatos[r][c] == 1) {
					Q.offer(new Point(r, c));
				}
			}
		}
		
		BFS();

		int max = -1;
		for(int r = 0; r < N; r++){
			for(int c = 0; c < M; c++) {
				if(tomatos[r][c] == 0) {
					System.out.println(-1);
					return;
				} else {
					max = tomatos[r][c] > max ? tomatos[r][c] : max;
				}
			}
		}
		
		System.out.println(max - 1); // 첫 토마토의 날짜는 빼주기
	}

	private static void BFS() {
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dx[i];
				int nc = p.c + dy[i];
				
				if(isIn(nr, nc) && tomatos[nr][nc] == 0) {
					Q.offer(new Point(nr, nc));
					tomatos[nr][nc] = tomatos[p.r][p.c] + 1;
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}

package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_4485_녹색옷입은애가젤다지 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int [][] map, cost;
	static boolean [][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			map = new int [N][N];
			cost = new int [N][N];
			visited = new boolean [N][N];
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					cost[r][c] = Integer.MAX_VALUE;
				}
			}
			
			findMinCost();
			
			output.append(String.format("Problem %d: %d\n", t++, cost[N-1][N-1]));
		}
		System.out.println(output);
	}

	private static void findMinCost() {
		PriorityQueue<Point> pQ = new PriorityQueue<>((p1, p2) -> Integer.compare(cost[p1.r][p1.c], cost[p2.r][p2.c]));
		
		cost[0][0] = map[0][0];
		pQ.add(new Point(0, 0));
		
		while(!pQ.isEmpty()) {
			Point now = pQ.poll();
			
			if(visited[now.r][now.c]) continue;
			visited[now.r][now.c] = true;
			
			if(now.r == N - 1 && now.c == N - 1) break;
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				
				if(cost[nr][nc] > cost[now.r][now.c] + map[nr][nc]) {
					cost[nr][nc] = cost[now.r][now.c] + map[nr][nc];
					pQ.add(new Point(nr, nc));
				}
			}
		}
	}

}

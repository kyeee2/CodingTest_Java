import java.io.*;
import java.util.*;

public class BJ_S1_14716_현수막 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static int [][] map;
	static int [] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int [N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int result = 0;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 0) continue;
				
				Queue<Point> Q = new LinkedList<>();
				Q.offer(new Point(r, c));
				map[r][c] = 0;
				result++;
				
				while(!Q.isEmpty()) {
					Point now = Q.poll();
					
					for(int i = 0; i < 8; i++) {
						int nr = now.r + dr[i];
						int nc = now.c + dc[i];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
						if(map[nr][nc] == 0) continue;
						
						Q.offer(new Point(nr, nc));
						map[nr][nc] = 0;
					}
				}
			}
		}
		
		System.out.println(result);
	}

}

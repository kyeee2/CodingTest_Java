import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_4963_섬의개수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		while(true) {
			tokens = new StringTokenizer(br.readLine());
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			
			if(N == 0 && M == 0) break;
			
			map = new int [N][M];
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(br.readLine());
				for(int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			output.append(countIsland() + "\n");
		}
		System.out.println(output);
	}

	private static int countIsland() {
		int cnt = 0;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 0) continue;
				
				cnt++;
				Queue<Point> Q = new LinkedList<>();
				Q.offer(new Point(r, c));
				map[r][c] = 0;
				
				while(!Q.isEmpty()) {
					Point now = Q.poll();
					
					for(int i = 0; i < 8; i++) {
						int nr = now.r + dr[i];
						int nc = now.c + dc[i];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0) continue;
						
						Q.offer(new Point(nr, nc));
						map[nr][nc] = 0;
					}
				}
			}
		}
		
		return cnt;
	}

}

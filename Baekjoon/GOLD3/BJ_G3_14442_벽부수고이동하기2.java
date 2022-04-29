import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_14442_벽부수고이동하기2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, K, min;
	static int [][] map;
	static boolean [][][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point {
		int r, c, k, cnt;
		
		public Point(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
		
		@Override
		public String toString() {
			return r + ", " + c + " : " + k + " : " + cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());

		map = new int [N][M];
		visited = new boolean [N][M][K + 1]; // 0~K번
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
		
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void bfs() {
		Queue<Point> Q = new LinkedList<>();
		
		Q.offer(new Point(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			if(now.r == N - 1 && now.c == M - 1) {
				min = Math.min(min, now.cnt + 1);
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(map[nr][nc] == 1 && now.k < K && !visited[nr][nc][now.k + 1]) {
					Q.offer(new Point(nr, nc, now.k + 1, now.cnt + 1));
					visited[nr][nc][now.k + 1] = true;
				}
				if(map[nr][nc] == 0 && !visited[nr][nc][now.k]) {
					Q.offer(new Point(nr, nc, now.k, now.cnt + 1));
					visited[nr][nc][now.k] = true;
				}
			}
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_18405_경쟁적전염 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K, S, X, Y;
	static int [][] map;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static PriorityQueue<Point> Q = new PriorityQueue<>();
	
	static class Point implements Comparable<Point> {
		int r, c, k, time; // k: 바이러스 종류, time: 걸린 시간
		
		public Point(int r, int c, int k, int time) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			if(this.time == o.time) {
				return Integer.compare(this.k, o.k);
			} else {
				return Integer.compare(this.time, o.time);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c< N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] > 0) {
					Q.add(new Point(r, c, map[r][c], 0));
				}
			}
		}

		tokens = new StringTokenizer(br.readLine());
		S = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());
		Y = Integer.parseInt(tokens.nextToken());
		
		bfs();
		
		System.out.println(map[X-1][Y-1]);
	}

	private static void bfs() {
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			if(now.time == S) break;
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] > 0) continue;
				
				Q.add(new Point(nr, nc, now.k, now.time + 1));
				map[nr][nc] = now.k;
			}
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_D4_1249_보급로 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, min;
	static int [][] map;
	static int [] dr = { -1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point implements Comparable<Point> {
		int r, c, cnt;
		
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			for(int r = 0; r < N; r++) {
				String line = br.readLine();
				for(int c = 0; c < N; c++) {
					map[r][c] = line.charAt(c) - '0';
				}
			}
			
			min = bfs();
			
			output.append(String.format("#%d %d\n", t, min));
		}
		System.out.println(output);
	}

	private static int bfs() {
		PriorityQueue<Point> pQ = new PriorityQueue<>();
		boolean [][] visited = new boolean [N][N];
		
		pQ.add(new Point(0, 0, map[0][0]));
		visited[0][0] = true;
		
		while(true) {
			Point now = pQ.poll();
			
			if(now.r == N - 1 && now.c == N - 1) {
				return now.cnt;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				
				pQ.add(new Point(nr, nc, now.cnt + map[nr][nc]));
				visited[nr][nc] = true;
			}
		}
	}
	
}

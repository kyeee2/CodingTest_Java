import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G1_1194_달이차오른다가자 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, nowR, nowC;
	static char [][] map;
	static boolean [][][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point  {
		int r, c, move, key;
		
		public Point(int r, int c, int move, int key) {
			this.r = r;
			this.c = c;
			this.move = move;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", move=" + move + ", key=" + key + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new char [N][M];
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c);
				
				// 시작 위치
				if(map[r][c] == '0') {
					nowR = r;
					nowC = c;
					map[r][c] = '.';
				}
			}
		}
		
		Queue<Point> Q = new LinkedList<>();
		visited = new boolean [N][M][1 << 6];
		
		Q.add(new Point(nowR, nowC, 0, 0));
		visited[nowR][nowC][0] = true;

		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			if(map[now.r][now.c] == '1') {
				System.out.println(now.move);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc][now.key]) continue;
				
				if(map[nr][nc] == '.' || map[nr][nc] == '1') {
					visited[nr][nc][now.key] = true;
					Q.add(new Point(nr, nc, now.move + 1, now.key));
				} else if('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
					int next_key = now.key | 1 << (map[nr][nc] - 'a');

					visited[nr][nc][next_key] = true;
					Q.add(new Point(nr, nc, now.move + 1, next_key));
				} else if('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
					if((now.key & 1 << (map[nr][nc] - 'A')) != 0) {
						visited[nr][nc][now.key] = true;
						Q.add(new Point(nr, nc, now.move + 1, now.key));
					}
				}
			}
		}
		System.out.println(-1);
	}

}

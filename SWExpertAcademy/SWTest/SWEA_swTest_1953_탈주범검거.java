import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_swTest_1953_탈주범검거 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, M, nowR, nowC, L;
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}; // 상, 우, 하, 좌
	static int [][] types = {{}, {0, 1, 2, 3}, {0, 2}, {1, 3}, {0, 1}, {1, 2}, {2, 3}, {0, 3}}; // 터널 구조물 타입

	static class Point {
		int r, c, time;
		
		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			nowR = Integer.parseInt(tokens.nextToken());
			nowC = Integer.parseInt(tokens.nextToken());
			L = Integer.parseInt(tokens.nextToken());
			
			map = new int [N][M];
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(br.readLine());
				for(int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			output.append(String.format("#%d %d\n", t, bfs()));
		}
		System.out.println(output);
	}

	private static int bfs() {
		Queue<Point> Q = new LinkedList<>();
		visited = new boolean [N][M];
		
		Q.add(new Point(nowR, nowC, 1));
		visited[nowR][nowC] = true;
		
		int cnt = 0;
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			if(now.time > L) break;
			cnt++;
			
			int type = map[now.r][now.c];
			for(int i = 0; i < types[type].length; i++) {
				int dir = types[type][i];
				int nr = now.r + dr[dir];
				int nc = now.c + dc[dir];
				
				if(isPossible(nr, nc, dir)) {
					Q.add(new Point(nr, nc, now.time + 1));
					visited[nr][nc] = true;
				}
			}
		}
		
		return cnt;
	}

	// 지금 방향으로 갈 수 있는지 체크
	private static boolean isPossible(int r, int c, int dir) {
		// 범위를 벗어났거나 파이프가 없거나 이미 방문했다면
		if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 0 || visited[r][c]) return false;
		
		// 파이프가 연결이 되어있는가
		int [] dirs = types[map[r][c]];
		for(int i = 0; i < dirs.length; i++) {
			// 현재 방향과 반대 방향이 있다면 연결 되어있음
			if(dirs[i] == (dir + 2) % 4) return true;
		}
		// 아니면 연결 안되어있음
		return false;
	}

}

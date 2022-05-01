import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_6593_상범빌딩 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int H, N, M, sh, sr, sc, eh, er, ec; // 시작 위치: sh & sr & sc, 탈출 위치: eh & er & ec
	static char [][][] map;
	static boolean [][][] visited;
	static int [] dr = {-1, 0, 1, 0, 0, 0}, dc = {0, 1, 0, -1, 0, 0}, dh = {0, 0, 0, 0, 1, -1}; // 북동남서상하
	
	static class Point {
		int h, r, c, cnt;

		public Point(int h, int r, int c, int cnt) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		while(true) {
			tokens = new StringTokenizer(br.readLine());
			H = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			if(H == 0 && N == 0 && M == 0) break;
			
			map = new char [H][N][M];
			for(int h = 0; h < H; h++) {
				for(int r = 0; r < N; r++) {
					String line = br.readLine();
					for(int c = 0; c < M; c++) {
						map[h][r][c] = line.charAt(c);
						// 시작 위치
						if(map[h][r][c] == 'S') {
							sh = h;
							sr = r;
							sc = c;
							map[h][r][c] = '.';
						}
						// 탈출 위치
						if(map[h][r][c] == 'E') {
							eh = h;
							er = r;
							ec = c;
							map[h][r][c] = '.';
						}
					}
				}
				br.readLine(); // 빈줄 버리기
			}
			
			visited = new boolean [H][N][M];
			output.append(bfs() + "\n");
		}
		System.out.println(output);
	}

	private static String bfs() {
		Queue<Point> Q = new LinkedList<>();
		
		Q.offer(new Point(sh, sr, sc, 0));
		visited[sh][sr][sc] = true;
		
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			if(now.h == eh && now.r == er && now.c == ec) {
				return String.format("Escaped in %d minute(s).", now.cnt);
			}
			
			for(int i = 0; i < 6; i++) {
				int nh = now.h + dh[i];
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 인덱스 벗어남
				if(map[nh][nr][nc] != '.' || visited[nh][nr][nc]) continue; // 금이거나 이미 방문함
				
				Q.offer(new Point(nh, nr, nc, now.cnt + 1));
				visited[nh][nr][nc] = true;
			}
		}
		
		return "Trapped!";
	}

}

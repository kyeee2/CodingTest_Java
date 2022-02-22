import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_1600_말이되고픈원숭이 {
	
	static class Point {
		int r, c, cnt, horse; // horse: 말 처럼 움직인 횟수
		
		public Point(int r, int c, int cnt, int horse) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.horse = horse;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int K = Integer.parseInt(br.readLine());
		tokens = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(tokens.nextToken());
		int N = Integer.parseInt(tokens.nextToken());
		
		int [][] map = new int[N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				if(tokens.nextToken().charAt(0) == '1') map[r][c] = 1; // 장애물을 -1로 표현
			}
		}
		
		int [] hdr = {-2, -1, 1, 2, 2, 1, -1, -2}, hdc = {1, 2, 2, 1, -1, -2, -2, -1}; // 말 이동
		int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}; // 일반 이동
		
		boolean [][][] visited = new boolean[N][M][K + 1]; // 말 이동 횟수에 따라 방문 여부 판단 <- 포인트
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		int result = Integer.MAX_VALUE;
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			if(now.r == N - 1 && now.c == M - 1) { // 도착!
				result = Math.min(result, now.cnt);
				// break; // 이거 있으면 최소를 못구함!!!
			}

			// 기본 이동
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 범위 벗어남
				if(now.horse > K || visited[nr][nc][now.horse] || map[nr][nc] == 1) continue; // 벽 또는 이미 지남
				
				Q.offer(new Point(nr, nc, now.cnt + 1, now.horse));
				visited[nr][nc][now.horse] = true;
			}

			// 말처럼 이동
			if(now.horse < K) {
				for(int i = 0; i < 8; i++) {
					int nr = now.r + hdr[i];
					int nc = now.c + hdc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue; // 범위 벗어남
					if(visited[nr][nc][now.horse + 1] || map[nr][nc] == 1) continue; // 벽 또는 이미 지남
					
					Q.offer(new Point(nr, nc, now.cnt + 1, now.horse + 1));
					visited[nr][nc][now.horse + 1] = true;
				}
			}
		}
		
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else							System.out.println(result);
	}

}

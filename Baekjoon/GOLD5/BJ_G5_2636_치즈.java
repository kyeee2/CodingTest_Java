import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_2636_치즈 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static boolean [][] cheezes;
	static boolean [][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static Queue<Point> Q = new LinkedList<>();
	
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
		
		cheezes = new boolean [N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				if(Integer.parseInt(tokens.nextToken()) == 1) cheezes[r][c] = true;
			}
		}
		
		int time = 0;
		int lastCnt = 0;
		while(true) {
			visited = new boolean [N][M];
			time++;
						
			// 바깥의 공기들을 체크해주기
			Q.offer(new Point(0, 0));
			visited[0][0] = true; // 공기라면 true
			
			while(!Q.isEmpty()) {
				Point now = Q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || cheezes[nr][nc]) continue;
					
					Q.offer(new Point(nr, nc));
					visited[nr][nc] = true;
				}
			}
			
			int cheeze = 0; // 공기와 닿은 치즈 개수
			for(int r = 1; r < N - 1; r++) {
				for(int c = 1; c < M - 1; c++) {
					if(!cheezes[r][c]) continue;
					
					int cnt = 0;
					for(int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						// 공기와 닿은 경우
						if(visited[nr][nc]) cnt++;
					}
					
					if(cnt > 0) {
						cheeze++;
						cheezes[r][c] = false;
					}
				}
			}
			
			if(cheeze == 0) break;
			lastCnt = cheeze;
		}
		
		System.out.println(time - 1);
		System.out.println(lastCnt);

	}

}

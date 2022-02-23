import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_2146_다리만들기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, minBridge = Integer.MAX_VALUE;
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point {
		int r, c, dist;
		
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.dist = d;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = -1 * Integer.parseInt(tokens.nextToken());
			}
		}
		
		// 같은 대륙은 같은 숫자로 표시
		int cnt = 0; // 대륙 개수
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] != -1) continue; // 바다라면
				
				cnt++;
				
				visited = new boolean [N][N];
				Queue<Point> Q = new LinkedList<>();
				Q.offer(new Point(r, c, 0));
				visited[r][c] = true;
				
				while(!Q.isEmpty()) {
					Point now = Q.poll();
					map[now.r][now.c] = cnt;
					
					for(int i = 0; i < 4; i++) {
						int nr = now.r + dr[i];
						int nc = now.c + dc[i];
						
						if(nr < 0 | nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0 || visited[nr][nc]) continue;
						
						Q.offer(new Point(nr, nc, now.dist + 1));
						visited[nr][nc] = true;
					}
				}
			}
		}

		// 다리 놓기
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 0) continue; // 바다라면
				
				boolean flag = false;
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr < 0 | nr >= N || nc < 0 || nc >= N) continue;
					if(map[nr][nc] == 0) { // 바다에 한 면이라도 닿아있는가
						flag = true;
						break;
					}
				}
				
				if(!flag) continue; // 대륙내라면
				
				visited = new boolean [N][N];
				Queue<Point> Q = new LinkedList<>();
				Q.offer(new Point(r, c, 0));
				visited[r][c] = true;
				
				outer : while(!Q.isEmpty()) {
					Point now = Q.poll();
					
					if(minBridge < now.dist) break;
					
					for(int i = 0; i < 4; i++) {
						int nr = now.r + dr[i];
						int nc = now.c + dc[i];
						
						if(nr < 0 | nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
						if(map[nr][nc] != 0) { // 대륙에 닿았다
							if(map[r][c] != map[nr][nc]) { // 다른 대륙에 닿았다면
								minBridge = Math.min(minBridge, now.dist);
								break outer;
							}
						} else {
							Q.offer(new Point(nr, nc, now.dist + 1));
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		
		System.out.println(minBridge);

	}

}

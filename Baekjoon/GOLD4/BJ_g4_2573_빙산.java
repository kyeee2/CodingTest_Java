import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_g4_2573_빙산 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, year;
	static int [][] map;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Ice {
		int r, c;
		
		public Ice(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		Queue<Ice> ices = new LinkedList<>();
		map = new int [N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(year = 1; ; year++) {
			boolean [][] visited = new boolean[N][M];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(map[r][c] == 0) continue;
					
					visited[r][c] = true;
					int cntWater = 0; // 바다에 닿는 면적
					for(int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
						
						if(map[nr][nc] <= 0) cntWater++; // 물이 닿는 면적
					}
					
					map[r][c] = map[r][c] - cntWater > 0 ? map[r][c] - cntWater : 0;
				}
			}

			visited = new boolean[N][M];
			int cnt = 0; // 빙산의 개수
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M ; c++) {
					if(map[r][c] == 0 || visited[r][c]) continue;
					
					cnt++;
					
					ices.offer(new Ice(r, c));
					visited[r][c] = true;
					while(!ices.isEmpty()) {
						Ice ice = ices.poll();
						
						for(int i = 0; i < 4; i++) {
							int nr = ice.r + dr[i];
							int nc = ice.c + dc[i];
							
							if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
							
							if(map[nr][nc] > 0) {
								ices.offer(new Ice(nr, nc));
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
			
			if(cnt == 0) {
				System.out.println(0);
				return;
			}
			if(cnt >= 2) {
				System.out.println(year);
				return;
			}
		} // end for
	}

}

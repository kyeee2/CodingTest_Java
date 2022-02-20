import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2178_미로탐색 {
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		boolean [][] map = new boolean[N][M];
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				if(line.charAt(c) == '1') {
					map[r][c] = true;
				} else {
					map[r][c] = false;
				}
			}
		}
		
		int [] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
		int [][] cnt = new int [N][M];
		
		Queue<Point> Q = new LinkedList<Point>();
		Q.offer(new Point(0, 0));
		map[0][0] = false;
		cnt[0][0] = 1;
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dx[i];
				int nc = p.c + dy[i];
				
				if(isIn(nr, nc) && map[nr][nc]) {
					Q.offer(new Point(nr, nc));
					map[nr][nc] = false;
					cnt[nr][nc] = cnt[p.r][p.c] + 1;
				}
			}
		}
		
		System.out.println(cnt[N - 1][M - 1]);
		
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}

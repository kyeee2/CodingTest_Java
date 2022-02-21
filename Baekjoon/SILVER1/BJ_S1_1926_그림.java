import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_1926_그림 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, cnt, max; // cnt: 그림 개수, max: 가장 넙은 면적
	static boolean [][] drawing;
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
		
		drawing = new boolean [N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				if(tokens.nextToken().equals("1")) {
					drawing[r][c] = true;
				}
			}
		}
		
		// BFS
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(drawing[r][c]) {
					Q.offer(new Point(r, c));
					drawing[r][c] = false;
					cnt++;
					int S = 0; // 면적
					
					while(!Q.isEmpty()) {
						Point p = Q.poll();
						S++;
						
						for(int i = 0; i < 4; i++) {
							int nr = p.r + dr[i];
							int nc = p.c + dc[i];
							
							if(isIn(nr, nc) && drawing[nr][nc]) {
								Q.offer(new Point(nr, nc));
								drawing[nr][nc] = false;
							}
						}
					}
					
					if(S > max) max = S;
				}
			}
		}
		
		System.out.println(cnt + "\n" + max);

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}

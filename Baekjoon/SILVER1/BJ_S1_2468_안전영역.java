import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2468_안전영역 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, maxArea = -1;
	static int [][] map;
	static boolean [][] water;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		int maxH = -1; // minH: 최소 높이. maxH: 최대 높이
		map = new int [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] > maxH) maxH = map[r][c];
			}
		}
		
		for(int height = 0; height <= maxH; height++) { // 비가 오지 않는 경우도 고려
			water = new boolean [N][N]; // 물이 차있는가?
			
			// 물이 차있는지 체크
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(map[r][c] <= height) {
						water[r][c] = true;
					}
				}
			}
			
			int cnt = countArea(); // 안전 영역의 개수 찾기
			
			maxArea = Math.max(maxArea, cnt);
		}
		
		System.out.println(maxArea);
	}

	private static int countArea() {
		int cnt = 0; // 안전영역 개수
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(water[r][c]) continue; // 물이 차있다면 넘어가기
				
				Queue<Point> Q = new LinkedList<Point>();
				Q.offer(new Point(r, c));
				water[r][c] = true;
				cnt++; // 안전영역 개수 늘려주기
				
				while(!Q.isEmpty()) {
					Point now = Q.poll();
					
					for(int i = 0; i < 4; i++) {
						int nr = now.r + dr[i];
						int nc = now.c + dc[i];
						
						// 인덱스를 벗어났거나, 물이 차있는 경우
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || water[nr][nc]) continue;
						
						Q.offer(new Point(nr, nc));
						water[nr][nc] = true;
					}
				}
			}
		}
		
		return cnt;
	}

}

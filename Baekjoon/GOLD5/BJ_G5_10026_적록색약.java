import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_G5_10026_적록색약 {
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char [][] map1 = new char [N][N]; // 적록색약이 아닌 경우
		char [][] map2 = new char [N][N]; // 적록색약인 경우
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < N; c++) {
				// 적록색약이 아닌 경우
				map1[r][c] = line.charAt(c);
				// 적록색약인 경우
				if(line.charAt(c) == 'G') map2[r][c] = 'R'; // 초록을 빨강으로
				else map2[r][c] = line.charAt(c);
			}
		}
		
		int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
		int cnt1 = 0, cnt2 = 0; // 뻘강 개수, 파랑 개수

		// 적록색약이 아닌 경우
		Queue<Point> Q = new LinkedList<>();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map1[r][c] == 'X') continue; // 이미 지나온 곳은 X로 표시
				
				char color = map1[r][c];
				cnt1++;
				
				Q.offer(new Point(r, c));
				map1[r][c] = 'X';
				
				while(!Q.isEmpty()) {
					Point p = Q.poll();
					
					for(int i = 0; i < 4; i++) {
						int nr = p.r + dr[i];
						int nc = p.c + dc[i];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						if(map1[nr][nc] != color) continue;
						
						Q.offer(new Point(nr, nc));
						map1[nr][nc] = 'X';
					}
				}
			}
		}
		
		// 적록색약인 경우
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map2[r][c] == 'X') continue; // 이미 지나온 곳은 X로 표시
				
				char color = map2[r][c];
				cnt2++;
				
				Q.offer(new Point(r, c));
				map2[r][c] = 'X';
				
				while(!Q.isEmpty()) {
					Point p = Q.poll();
					
					for(int i = 0; i < 4; i++) {
						int nr = p.r + dr[i];
						int nc = p.c + dc[i];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						if(map2[nr][nc] != color) continue;
						
						Q.offer(new Point(nr, nc));
						map2[nr][nc] = 'X';
					}
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);

	}

}

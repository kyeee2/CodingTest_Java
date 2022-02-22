import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_7562_나이트의이동 {
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int [][] map = new int [N][N];
			for(int [] row: map) {
				Arrays.fill(row, -1);
			}
			
			tokens = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(tokens.nextToken());
			int startC = Integer.parseInt(tokens.nextToken());
			tokens = new StringTokenizer(br.readLine());
			int endR = Integer.parseInt(tokens.nextToken());
			int endC = Integer.parseInt(tokens.nextToken());
			
			int [] dr = {-2, -1, 1, 2, 2, 1, -1, -2}, dc = {1, 2, 2, 1, -1, -2, -2, -1};
			Queue<Point> Q = new LinkedList<>();
			Q.offer(new Point(startR, startC));
			map[startR][startC] = 0;
			
			while(!Q.isEmpty()) {
				Point p = Q.poll();
				if(p.r == endR && p.c == endC) break; // 도착
				
				for(int i = 0; i < 8; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue; // 인덱스 벗어남
					if(map[nr][nc] != -1) continue; // 이미 지나침
					
					Q.offer(new Point(nr, nc));
					map[nr][nc] = map[p.r][p.c]+ 1; 
				}
			} // end while
			
			output.append(map[endR][endC] + "\n");
		}
		
		System.out.println(output);
		
	}

}

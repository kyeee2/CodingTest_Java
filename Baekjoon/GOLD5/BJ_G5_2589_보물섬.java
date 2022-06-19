import java.io.*;
import java.util.*;

public class BJ_G5_2589_보물섬 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, maxDist;
	static boolean [][] map;
	static List<Point> lands = new ArrayList<>();
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point {
		int r, c, dist;
		
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.dist = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new boolean [N][M];
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				if(line.charAt(c) == 'L') {
					map[r][c] = true;
					lands.add(new Point(r, c, 0));
				}
			}
		}
		
		for(int i = 0; i < lands.size(); i++) {
			solution(lands.get(i));
		}
		System.out.println(maxDist);
	}

	private static void solution(Point point) {
		Queue<Point> Q = new LinkedList<>();
		boolean [][] visited = new boolean [N][M];
		
		Q.add(point);
		visited[point.r][point.c] = true;
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			if(maxDist < now.dist) maxDist = now.dist;
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(!map[nr][nc] || visited[nr][nc]) continue;
				
				Q.add(new Point(nr, nc, now.dist + 1));
				visited[nr][nc] = true;
			}
		}
	}

}

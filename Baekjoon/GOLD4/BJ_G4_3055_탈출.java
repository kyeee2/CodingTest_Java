import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_3055_탈출 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int R, C;
	static char [][] map;
	static int [][] water, d;
	static Queue<Point> waters, ds;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char [R][C];
		water = new int [R][C];
		d = new int [R][C];
		waters = new LinkedList<>();
		ds = new LinkedList<>();
		for(int r = 0; r < R; r++) {
			String line = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == 'S') {
					ds.offer(new Point(r, c));
					d[r][c] = 1;
					map[r][c] = '.';
				}
				if(map[r][c] == '*') {
					waters.offer(new Point(r, c));
					water[r][c] = 1;
					map[r][c] = '.';
				}
			}
		}
		
		bfs_water();
		int result = bfs_d();
		System.out.println(result == -1 ? "KAKTUS" : result);
	}

	private static void bfs_water() {
		while(!waters.isEmpty()) {
			Point now = waters.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(map[nr][nc] != '.' || water[nr][nc] != 0) continue;
				
				waters.offer(new Point(nr, nc));
				water[nr][nc] = water[now.r][now.c] + 1;
			}
		}
		
	}

	private static int bfs_d() {
		while(!ds.isEmpty()) {
			Point now = ds.poll();
			
			if(map[now.r][now.c] == 'D') return d[now.r][now.c] - 1;
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(map[nr][nc] == 'X' || d[nr][nc] != 0 || (water[nr][nc] > 0 && water[nr][nc] <= d[now.r][now.c] + 1)) continue;
				
				ds.offer(new Point(nr, nc));
				d[nr][nc] = d[now.r][now.c] + 1;
			}
		}
		return -1;
	}

}

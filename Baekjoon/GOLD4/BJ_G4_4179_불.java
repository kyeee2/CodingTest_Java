import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_4179_불 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int R, C;
	static Point now;
	static int [][] person, fire;
	static char [][] maze;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static Queue<Point> persons = new LinkedList<>(); 
	static Queue<Point> fires = new LinkedList<>();
	
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
		
		maze = new char [R][C];
		person = new int[R][C];
		fire = new int[R][C];
		for(int r = 0; r < R; r++) {
			String line = br.readLine();
			for(int c = 0; c < C; c++) {
				char ch = line.charAt(c);
				
				maze[r][c] = ch;
				if(ch == 'J') {
					person[r][c] = 0;
					persons.offer(new Point(r, c));
				} else {
					person[r][c] = -1;
				}
				if(ch == 'F') {
					fire[r][c] = 0;
					fires.offer(new Point(r, c));
				} else {
					fire[r][c] = -1;
				}
			}
		}
		
		// 불 먼저
		while(!fires.isEmpty()) {
			Point p = fires.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(fire[nr][nc] >= 0 || maze[nr][nc] == '#') continue;
				
				fire[nr][nc] = fire[p.r][p.c] + 1;
				fires.offer(new Point(nr, nc));
			}
		}
		
		// 지훈이
		while(!persons.isEmpty()) {
			Point p = persons.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
					System.out.println(person[p.r][p.c] + 1);
					return;
				}
				if(person[nr][nc] >= 0 || maze[nr][nc] == '#') continue;
				if(fire[nr][nc] !=  -1 && fire[nr][nc] <= person[p.r][p.c] + 1) continue; // 불이랑 비교
				
				person[nr][nc] = person[p.r][p.c] + 1;
				persons.offer(new Point(nr, nc));
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}

}

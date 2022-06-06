import java.io.*;
import java.util.*;

public class BJ_G5_14503_로봇청소기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Robot {
		int r, c, dir;
		
		public Robot(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Robot [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int dir = Integer.parseInt(tokens.nextToken());
		Robot robot = new Robot(r, c, dir);
		
		map = new int [N][M];
		visited = new boolean [N][M];
		for(r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int time = 0;
		while(true) {
			boolean flag = false;
			
			if(!visited[robot.r][robot.c]) {
				time++;
				visited[robot.r][robot.c] = true;
			}
			
			for(int i = 1; i <= 4; i++) {
				int nDir = (robot.dir - i + 4) % 4;
				int nr = robot.r + dr[nDir];
				int nc = robot.c + dc[nDir];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(map[nr][nc] == 1 || visited[nr][nc]) continue;
				
				robot.r = nr;
				robot.c = nc;
				robot.dir = nDir;
				flag = true;
				break;
			}
			
			if(!flag) {
				int nr = robot.r + dr[(robot.dir + 2) % 4];
				int nc = robot.c + dc[(robot.dir + 2) % 4];
				
				if(map[nr][nc] == 1) { // 벽인 경우 작동을 멈춘다.
					break;
				} else {
					robot.r = nr;
					robot.c = nc;
				}
			}
		}
		
		System.out.println(time);
	}

}

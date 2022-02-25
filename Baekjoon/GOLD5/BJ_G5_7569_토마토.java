import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_7569_토마토 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, H; 
	static int [][][] tomatos;
	static int [] dx = {0, 0, -1, 0, 1, 0}, dy = {0, 0, 0, 1, 0, -1}, dz = {-1, 1, 0, 0, 0, 0};
	
	static class Point {
		int x, y, z;
		
		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		
		Queue<Point> Q = new LinkedList<>();
		tomatos = new int [H][N][M];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				tokens = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					tomatos[i][j][k] = Integer.parseInt(tokens.nextToken());
					if(tomatos[i][j][k] == 1) {
						Q.offer(new Point(j, k, i));
					}
				}
			}
		}
		
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			for(int i = 0; i < 6; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nz = now.z + dz[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H || tomatos[nz][nx][ny] == -1 || tomatos[nz][nx][ny] > 0) continue;
				
				tomatos[nz][nx][ny] = tomatos[now.z][now.x][now.y] + 1;
				Q.offer(new Point(nx, ny, nz));
			}
		}
		
		int max = -1;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(tomatos[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					max = tomatos[i][j][k] > max ? tomatos[i][j][k] : max;
 				}
			}
		}
		System.out.println(max - 1);
 		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_16985_Maaaaaaaaazee {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int result = Integer.MAX_VALUE;
	static int [][][][] cube = new int [4][5][5][5]; // 큐브의 가능한 경우들
	static int [][][] map = new int [5][5][5];		 // 현재 조립된 큐브
	static int [] orders = new int [5];
	static List<int []> perms = new ArrayList<>();  // i번째에 어떤 판이 오는지 순서 집합
	static int [] dx = {0, 0, -1, 0, 1, 0}, dy = {0, 0, 0, 1, 0, -1}, dz = {1, -1, 0, 0, 0, 0};

	static class Point {
		int x, y, z;
		
		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		for(int z = 0; z < 5; z++) {
			for(int x = 0; x < 5; x++) {
				tokens = new StringTokenizer(br.readLine());
				for(int y = 0; y < 5; y++) {
					cube[0][z][x][y] = Integer.parseInt(tokens.nextToken());
				}
			}
		}
		
		// 큐브 90, 180, 270 돌린 경우 다 저장
		for(int i = 1; i < 4; i++) {
			rotate(i);
		}
		
		permutation(0, 0);
		
		for(int [] perm: perms) {
			// 모든 경우에 대해서 경로 찾기
			for(int bits = 0; bits < 1024; bits++) { // 4 ^ 5 경우
				// 큐브 조립하기
				int temp = bits;
				for(int i = 0; i < 5; i++) {
					int idx = temp & 3;
					temp >>= 2;
					map[i] = cube[idx][perm[i]];
				}
				
				result = Math.min(result, bfs());
			}
		}
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);

	}

	// 각각의 판에 회전 가능한 경우를 모두 저장
	private static void rotate(int n) {
		for(int z = 0; z < 5; z++) {
			for(int x = 0; x < 5; x++) {
				for(int y = 0; y < 5; y++) {
					cube[n][z][x][y] = cube[n - 1][z][y][4 - x];
				}
			}
		}
	}

	// 5개의 판을 어떻게 쌓을지 정하기
	private static void permutation(int cnt, int bits) {
		if(cnt == 5) {
			int [] temp = new int [5];
			for(int i = 0; i < 5; i++) {
				temp[i] = orders[i];
			}
			perms.add(temp);
			
			return;
		}
		
		for(int i = 0; i < 5; i++) {
			if((bits & 1 << i) != 0) continue;
			
			orders[cnt] = i;
			permutation(cnt + 1, bits | 1 << i);
		}
	}

	// 경로 찾기
	private static int bfs() {
		Queue<Point> Q = new LinkedList<>();
		int [][][] dist = new int [5][5][5];
		
		// 처음엔 무조건 (0, 0, 0) 으로 들어간다
		Q.offer(new Point(0, 0, 0));
		
		// 들어갈 수 없거나 빠져나올 수 없는 경우
		if(map[0][0][0] == 0 || map[4][4][4] == 0) return Integer.MAX_VALUE; 
		
		dist[0][0][0] = 1;
		
		while(!Q.isEmpty()) {
			Point now = Q.poll();

			if(now.z == 4 && now.x == 4 && now.y == 4) return dist[now.z][now.x][now.y] - 1;
			
			for(int i = 0; i < 6; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nz = now.z + dz[i];
				
				
				if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5 || dist[nz][nx][ny] != 0 || map[nz][nx][ny] == 0) continue;
				
				Q.offer(new Point(nx, ny, nz));
				dist[nz][nx][ny] = dist[now.z][now.x][now.y] + 1;
			}
		}
		
		return Integer.MAX_VALUE;
	}

}

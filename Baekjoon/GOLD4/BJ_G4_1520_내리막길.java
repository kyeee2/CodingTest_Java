import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_1520_내리막길 {
	
	// 참고 블로그 : https://wootool.tistory.com/83
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static int [][] map;
	static int [][] D;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int [N][M];
		D = new int [N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				D[r][c] = -1; // 초기화
			}
		}
		
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int r, int c) {
		if(r == N - 1 && c == M - 1) return 1;
		if(D[r][c] != -1) return D[r][c];
		
		D[r][c] = 0;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[r][c] <= map[nr][nc]) continue;
			
			D[r][c] += dfs(nr, nc);
		}
		
		return D[r][c];
	}

}

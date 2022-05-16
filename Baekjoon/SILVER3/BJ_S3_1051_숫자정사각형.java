import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_1051_숫자정사각형 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static char [][] map;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new char [N][M];
		for(int r = 0; r < N; r++) {
			map[r] =  br.readLine().toCharArray();
		}
		
		int max = 0; // 정사각형의 최대 가로값
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				for(int i = max + 1; i <= Math.min(N, M); i++) {
					if(r + i >= N || c + i >= M) break;
					
					if(map[r][c] == map[r + i][c] && map[r + i][c] == map[r + i][c + i]
							&& map[r + i][c + i] == map[r][c + i] && map[r][c + i] == map[r][c]) {
						System.out.println(r + ", " + c + " : " + i);
						max = i;
					}
				}
			}
		}
		
		System.out.println((max + 1) * (max + 1));
	}

}

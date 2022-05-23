import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_11048_이동하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static int [][] map, D;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		D = new int[N + 1][M + 1];
		for(int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 1; c <= M; c++) {
				D[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				int max = Math.max(D[r - 1][c - 1], D[r - 1][c]);
				max = Math.max(max, D[r][c - 1]);
				
				D[r][c] += max;
			}
		}
		
		System.out.println(D[N][M]);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_17070_파이프옮기기1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, result;
	static boolean [][] map;
	static int [][][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new boolean [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				if(Integer.parseInt(tokens.nextToken()) == 0) {
					map[r][c] = true; // 빈칸
				}
			}
		}
		dp = new int [N][N][3]; // 0: 가로, 1: 세로, 2: 대각선
		dp[0][1][0] = 1;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!map[r][c]) continue; // 벽
				
				if(c - 1 >= 0) dp[r][c][0] += dp[r][c - 1][0] + dp[r][c - 1][2]; // 가로
				if(r - 1 >= 0) dp[r][c][1] += dp[r - 1][c][1] + dp[r - 1][c][2]; // 세로
				
				if(r - 1 >= 0 && c - 1 >= 0 && map[r - 1][c] && map[r][c - 1]) {
					dp[r][c][2] += dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2]; // 대각선
				}
			}
		}
		
		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
		
	}

}

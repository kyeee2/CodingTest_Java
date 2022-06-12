import java.io.*;
import java.util.*;

public class BJ_S1_11660_구간합구하기5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static int [][] nums, D;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		nums = new int [N + 1][N + 1];
		D = new int [N + 1][N + 1];
		for(int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 1; c <= N; c++) {
				nums[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				D[r][c] = nums[r][c] + D[r - 1][c] + D[r][c - 1] - D[r - 1][c - 1];
			}
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());
			
			output.append((D[x2][y2] - D[x2][y1 - 1] - D[x1 - 1][y2] + D[x1 - 1][y1 - 1]) + "\n");
		}
		System.out.println(output);
	}

}

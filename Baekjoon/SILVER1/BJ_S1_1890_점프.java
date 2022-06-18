import java.io.*;
import java.util.*;

public class BJ_S1_1890_점프 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int [][] map;
	static long [][] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		D = new long [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		D[0][0] = 1;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				int next = map[r][c];
				if(next == 0) break;
				if(c + next < N) D[r][c + next] += D[r][c];
				if(r + next < N) D[r + next][c] += D[r][c];
			}
		}
		
		System.out.println(D[N-1][N-1]);
	}

}

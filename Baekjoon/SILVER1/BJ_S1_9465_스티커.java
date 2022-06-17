import java.io.*;
import java.util.*;

public class BJ_S1_9465_스티커 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N;
	static int [][] sticker, D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			sticker = new int [2][N + 1];
			D = new int [2][N + 1];
			for(int r = 0; r < 2; r++) {
				tokens = new StringTokenizer(br.readLine());
				for(int c = 1; c <= N; c++) {
					sticker[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			D[0][0] = 0;
			D[1][0] = 0;
			D[0][1] = sticker[0][1];
			D[1][1] = sticker[1][1];
			
			for(int c = 2; c <= N; c++) {
				D[0][c] = Math.max(D[1][c - 1], D[1][c - 2]) + sticker[0][c];
				D[1][c] = Math.max(D[0][c - 1], D[0][c - 2]) + sticker[1][c];
			}
			
			output.append(Math.max(D[0][N], D[1][N]) + "\n");
		}
		System.out.println(output);
	}

}

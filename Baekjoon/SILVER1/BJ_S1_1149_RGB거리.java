import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_1149_RGB거리 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int [] r, g, b;
	static int [][] D; // r, g, b

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		r = new int [N + 1];
		g = new int [N + 1];
		b = new int [N + 1];
		D = new int [N + 1][3];
		
		for(int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			r[i] = Integer.parseInt(tokens.nextToken());
			g[i] = Integer.parseInt(tokens.nextToken());
			b[i] = Integer.parseInt(tokens.nextToken());
		}
		
		D[1][0] = r[1];
		D[1][1] = g[1];
		D[1][2] = b[1];
		
		for(int i = 2; i <= N; i++) {
			D[i][0] = Math.min(D[i - 1][1],  D[i - 1][2]) + r[i];
			D[i][1] = Math.min(D[i - 1][0],  D[i - 1][2]) + g[i];
			D[i][2] = Math.min(D[i - 1][0],  D[i - 1][1]) + b[i];
		}
		
		System.out.println(Math.min(D[N][0], Math.min(D[N][1], D[N][2])));
	}

}

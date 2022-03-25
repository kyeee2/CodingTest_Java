import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_1932_정수삼각형 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int [][] tr, D;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		tr = new int [N][N];
		D = new int [N][N];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				tr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		D[0][0] = tr[0][0];
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				D[i][j] += tr[i][j];
				if(j == 0) D[i][j] += D[i - 1][j];
				else if(j == i) D[i][j] += D[i - 1][j - 1];
				else D[i][j] += Math.max(D[i - 1][j - 1], D[i - 1][j]);
			}
		}
		
		int max = -1;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, D[N-1][i]);
		}
		System.out.println(max);

	}

}

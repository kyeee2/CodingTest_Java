import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_S1_10844_쉬운계단수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static long mod = 1000000000;
	static long [][] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		D = new long [N + 1][10];
		
		// 한 자리는 전 부 다 계단 수
		D[1][0] = 0;
		for(int i = 1; i < 10; i++) {
			D[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0)		D[i][j] = D[i - 1][j + 1] % mod;
				else if(j == 9) D[i][j] = D[i - 1][j - 1] % mod;
				else 			D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % mod;
			}
		}
		
		long sum = 0;
		for(int i = 0; i < 10; i++) {
			sum = (sum + D[N][i]) % mod;
		}
		System.out.println(sum % mod);
	}

}

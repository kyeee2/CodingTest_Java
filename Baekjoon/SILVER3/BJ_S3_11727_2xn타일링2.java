import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S3_11727_2xn타일링2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, mod = 10007;
	static int [] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		D = new int [N + 1];
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		D[1] = 1;
		D[2] = 3; // 1*2 두개, 2*1 두개, 2x2 한개 => 총 3개
		for(int i = 3; i <= N; i++) {
			D[i] = (D[i - 1] + 2 * D[i - 2]) % mod;
		}
		
		System.out.println(D[N]);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G1_11401_이항계수3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K, mod = 1000000007;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		System.out.println(comb());
	}

	private static long comb() {
		if(K == 0) return 1;
		
		long [] fac = new long [N + 1];
		fac[0] = 1;
		
		for(int i = 1; i <= N; i++) {
			fac[i] = (fac[i - 1] * i) % mod;
		}
		
		return (fac[N] * power(fac[K], mod - 2) % mod * power(fac[N - K], mod - 2) % mod) % mod;
	}

	private static long power(long x, int y) {
		long ans = 1;
		
		x = x % mod;
		while(y > 0) {
			if(y % 2 == 1) {
				ans = (ans * x) % mod;
			}
			y = y >> 1;
			x = (x * x) % mod;
		}
		
		return ans;
	}

}

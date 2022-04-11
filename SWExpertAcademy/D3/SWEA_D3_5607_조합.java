import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_5607_조합 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, R, mod = 1234567891;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			
			output.append("#" + t + " " + comb() + "\n");
		}
		System.out.println(output);
	}

	private static long comb() {
		if(R == 0) return 1;
		
		long [] fac = new long [N + 1];
		fac[0] = 1;
		
		for(int i = 1; i <= N; i++) 
			fac[i] = fac[i - 1] * i % mod;
		
		return (fac[N] * power(fac[R], mod - 2) % mod * power(fac[N - R], mod - 2) % mod) % mod;
	}

	private static long power(long x, long y) {
		long ans = 1;
		
		x = x % mod;
		while(y > 0) {
			if(y % 2 == 1) 
				ans = (ans * x) % mod;
			y = y >> 1;
			x = (x * x) % mod;
		}
		
		return ans;
	}

}

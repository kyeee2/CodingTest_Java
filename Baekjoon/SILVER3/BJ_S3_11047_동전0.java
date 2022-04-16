import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_11047_동전0 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K, cnt;
	static int [] moneys;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		moneys = new int [N];
		for(int i = 0; i < N; i++) {
			moneys[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = N - 1; i >= 0; i--) {
			cnt += K / moneys[i];
			K %= moneys[i];
			
			if(K == 0) break;
		}
		
		System.out.println(cnt);
	}

}

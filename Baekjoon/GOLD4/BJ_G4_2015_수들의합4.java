import java.io.*;
import java.util.*;

public class BJ_G4_2015_수들의합4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K;
	static int [] sum;
	static Map<Integer, Long> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());

		long cnt = 0;
		sum = new int [N + 1];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sum[i] = Integer.parseInt(tokens.nextToken()) + sum[i - 1];
			
			if(sum[i] == K) cnt++;
			
			// sum[i] - sum[j] == K  ->  sum[i] - K == sum[j] 
			if(map.containsKey(sum[i] - K)) cnt += map.get(sum[i] - K);
			
			if(map.containsKey(sum[i])) map.put(sum[i], map.get(sum[i]) + 1);
			else map.put(sum[i], 1L);
		}
		
		System.out.println(cnt);
	}

}

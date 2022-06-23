import java.io.*;
import java.util.*;

public class BJ_G3_10986_나머지합 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static int [] nums, sum, count;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		nums = new int [N + 1];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}

		sum = new int [N + 1];
		count = new int [M];
		for(int i = 1; i <= N; i++) {
			sum[i] = (sum[i - 1] + nums[i]) % M;
			count[sum[i]]++;
		}
		
		long cnt = count[0];
		for(int i = 0; i < M; i++) {
			cnt += (long)count[i] * (count[i] - 1) / 2;
		}
		
		System.out.println(cnt);
	}

}

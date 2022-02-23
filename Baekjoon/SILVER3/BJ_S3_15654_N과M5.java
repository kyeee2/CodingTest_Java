import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_15654_N과M5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static int [] nums, result;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		nums = new int[N];
		result = new int [M];
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i ++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(nums);
		
		permutation(0, 0);
		
		System.out.println(output);
	}

	private static void permutation(int cnt, int bits) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				output.append(result[i] + " ");
			}
			output.append('\n');
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((bits & 1 << i) != 0) continue;
			
			result[cnt] = nums[i];
			permutation(cnt + 1, bits | 1 << i);
		}
	}

}

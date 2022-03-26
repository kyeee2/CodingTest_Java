import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_1912_연속합 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static long max;
	static int [] nums;
	static long [] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		nums = new int [N + 1];
		D = new long [N + 1];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		D[1] = nums[1];
		max = D[1];
		
		for(int i = 2; i <= N; i++) {
			D[i] = Math.max(nums[i], D[i - 1] + nums[i]);
			max = Math.max(max, D[i]);
		}
		System.out.println(max);
		
	}

}

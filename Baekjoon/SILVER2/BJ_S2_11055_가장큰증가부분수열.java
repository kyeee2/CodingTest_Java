import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_11055_가장큰증가부분수열 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, max;
	static int [] nums, D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int [N + 1];
		D = new int [N + 1];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		D[1] = nums[1];
		max = D[1];
		
		for(int i = 2; i <= N; i++) {
			D[i] = nums[i];
			for(int j = 1; j < i; j++) {
				if(nums[j] < nums[i]) {
					D[i] = Math.max(D[i], D[j] + nums[i]);
				}
			}
			max = Math.max(max, D[i]);
		}
		
		System.out.println(max);
	}

}

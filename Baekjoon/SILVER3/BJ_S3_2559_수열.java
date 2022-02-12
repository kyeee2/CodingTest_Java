import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_2559_수열 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		int [] nums = new int [N];
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i <N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= N - K; i++) {
			int sum = 0;
			for(int j = i; j < i + K; j++) {
				sum += nums[j];
			}
			
			if(sum > max) max = sum;
		}
		
		System.out.println(max);

	}

}

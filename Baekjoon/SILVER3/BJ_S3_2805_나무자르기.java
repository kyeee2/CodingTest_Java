import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		long M = Long.parseLong(tokens.nextToken());
		
		long max = -1;
		long [] trees = new long[N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(tokens.nextToken());
			if(trees[i] > max) max = trees[i];
		}
		
		long total = Long.MAX_VALUE, height = Long.MAX_VALUE;
		long min = 0;
		
		while(true) {
			if(min > max) {
				break;
			}
			
			long mid = (min + max) / 2;
			long sum = 0;
			for(int i = 0; i < N; i++) {
				if(trees[i] > mid) sum += trees[i] - mid;
			}
			if(sum == M) {
				height = mid;
				break;
			} else if(sum >= M && total > sum) {
				total = sum;
				height = mid;
			}
			
			if(sum > M) {
				min = mid + 1;
			} else if(sum < M) {
				max = mid - 1;
			}
			
		}
		
		System.out.println(height);

	}

}

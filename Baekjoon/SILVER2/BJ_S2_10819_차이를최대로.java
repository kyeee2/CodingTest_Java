import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_10819_차이를최대로 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, max = Integer.MIN_VALUE;
	static int [] nums;
	static int [] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		selected = new int [N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		findMaxDiff(0, 0);

		System.out.println(max);
	}

	private static void findMaxDiff(int cnt, int bits) {
		if(cnt == N) {
			int sum = 0;
			for(int i = 1; i < N; i++) {
				sum += Math.abs(selected[i - 1] - selected[i]);
			}
			
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((bits & 1 << i) != 0) continue;
			
			selected[cnt] = nums[i];
			findMaxDiff(cnt + 1, bits | 1 << i);
		}
	}

}

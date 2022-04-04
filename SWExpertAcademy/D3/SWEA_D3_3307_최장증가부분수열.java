import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_3307_최장증가부분수열 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N;
	static long [] nums, D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			nums = new long [N + 1];
			D = new long [N + 1];
			tokens = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				nums[i] = Integer.parseInt(tokens.nextToken());
			}
			
			D[1] = nums[1];
			
			int idx = 2;
			for(int i = 2; i <= N; i++) {
				boolean flag = true;
				for(int j = 1; j < idx; j++) {
					if(nums[i] < D[j]) {
						D[j] = nums[i];
						flag = false;
						break;
					}
				}
				
				if(flag) {
					D[idx++] = nums[i];
				}
			}
			
			output.append(String.format("#%d %d\n", t, idx - 1));
		}
		System.out.println(output);
	}

}

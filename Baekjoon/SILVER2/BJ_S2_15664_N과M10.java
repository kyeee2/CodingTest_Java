import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_S2_15664_N과M10 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static int [] nums, result;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		nums = new int [N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(nums);
		
		result = new int [M];
		combination(0, 0);
		
		System.out.println(output);
	}

	private static void combination(int cnt, int start) {
		if(cnt == M) {
			String str = "";
			for(int i = 0; i < M; i++) {
				str += result[i] + " ";
			}
			if(!set.contains(str)) {
				output.append(str + "\n");
				set.add(str);
			}
			
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = nums[i];
			combination(cnt + 1, i + 1);
		}
	}

}

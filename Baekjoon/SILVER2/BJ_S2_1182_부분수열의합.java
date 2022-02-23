import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_1182_부분수열의합 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, S, result;
	static int [] nums;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		
		nums = new int[N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		calcSum(0, 0);
		
		if(S == 0) { // count 합이 0인 경우 공집합도 포함되므로 그 수를 하나 빼주고 풀력해준다
			result--;
		}
		System.out.println(result);
	}

	private static void calcSum(int cnt, int sum) {
		if(cnt == N) {
			if(sum == S) result++;
			return;
		}
		
		calcSum(cnt + 1, sum + nums[cnt]);
		calcSum(cnt + 1, sum);
	}

}

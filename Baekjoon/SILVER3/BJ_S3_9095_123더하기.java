import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S3_9095_123더하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int T, N, cnt;
	static int [] D = new int [11];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		useDP();
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			output.append(D[N] + "\n");
			
			/*
			cnt = 0;
			findSum(0);
			output.append(cnt).append('\n');
			*/
		}
		System.out.println(output);

	}

	// DP 사용
	private static int useDP() {
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for(int i = 4; i < 11; i++) {
			D[i] = D[i - 1] + D[i - 2] + D[i - 3];
		}
		
		return D[N];
	}
	
	// 백트레킹 사용
	/*
	private static void findSum(int sum) {
		if(sum > N) {
			return;
		}
		
		if(sum == N) {
			cnt++;
			return;
		}
		
		findSum(sum + 1);
		findSum(sum + 2);
		findSum(sum + 3);
		
	}
	 */
}

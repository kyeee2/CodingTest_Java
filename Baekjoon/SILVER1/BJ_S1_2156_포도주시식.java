import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S1_2156_포도주시식 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int [] nums;
	static int [][] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int [N + 1];
		D = new int [N + 1][3];
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		if(N == 1) {
			System.out.println(nums[1]);
			return;
		}
		
		// D[i][0]: i번째 음료를 마시지 않는 경우 		 -> i-1번째에서 가장 큰 값 가져오기
		// D[i][1]: i번째 음료를 1번째 연속으로 마신 경우 -> i-2번째애서 가장 큰 값 + 현재 포도주 값
		// D[i][2]: i번째 음료를 2번째 연속으로 마신 경우 -> i-1번째에서 1번 연속으로 마신 값 + 현재 포도잔 값
		
		D[1][0] = 0;
		D[1][1] = nums[1];
		D[1][2] = 0;
		D[2][0] = nums[1];
		D[2][1] = nums[2];
		D[2][2] = nums[1] + nums[2];
		for(int i = 3; i <= N; i++) {
			D[i][0] += Math.max(D[i - 1][0], Math.max(D[i - 1][1], D[i - 1][2]));
			D[i][1] += Math.max(D[i - 2][0], Math.max(D[i - 2][1], D[i - 2][2])) + nums[i];
			D[i][2] += D[i - 1][1] + nums[i];
		}
		
		System.out.println(Math.max(D[N][0], Math.max(D[N][1], D[N][2])));
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_11053_가장긴증가하는부분수열 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, num, max = -1;
	static int [] nums, D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		nums = new int [N + 1];
		D = new int[N + 1];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		D[1] = 1;
		num = nums[1];
		
		for(int i = 2; i <= N; i++) {
			D[i] = 1; // 일단 내가 첫 시작이라고 생각
			for(int j = 1; j < i; j++) {
				// 이전 수 중에서 현재 i 값보다 작은 수의 부분수열 중 가장 큰 값 찾기
				if(nums[j] < nums[i]) {
					D[i] = Math.max(D[i], D[j] + 1);
				}
			}
			max = Math.max(max, D[i]);
		}
		
		System.out.println(max);
	}

}

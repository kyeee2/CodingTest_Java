import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_14002_가장긴증가하는부분수열4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int [] nums, D, pre;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int [N + 1];
		D = new int [N + 1];
		pre = new int [N + 1]; // 이전 인덱스 담아주기
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		// 초기값
		D[1] = 1;
		
		int idx = 1;
		int max = D[1];
		for(int i = 1; i <= N; i++) {
			D[i] = 1;
			for(int j = 1; j < i; j++) {
				if(nums[j] < nums[i]) {
					if(D[j] + 1 > D[i]) {
						D[i] = D[j] + 1;
						pre[i] = j;
					}
				}
				if(D[i] > max) {
					idx = i;
					max = D[i];
				}
			}
		}
		
		output.append(nums[idx]);
		while(pre[idx] > 0) {
			output.insert(0, nums[pre[idx]] + " ");
			idx = pre[idx];
		}
		System.out.println(max);
		System.out.println(output);
	}

}

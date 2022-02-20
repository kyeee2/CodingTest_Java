package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S3_9095_123더하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int T, N, cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			cnt = 0;
			findSum(0);
			
			output.append(cnt).append('\n');
		}
		System.out.println(output);

	}

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

}

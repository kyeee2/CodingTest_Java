package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_2491_수열 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int [] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int max = 1;
		int cnt = 1;
		for(int i = 1; i < N; i++) {
			if(nums[i - 1] > nums[i]) {
				cnt = 1;
			} else {
				cnt++;
			}
			max = Math.max(cnt, max);
		}

		cnt = 1;
		for(int i = 1; i < N; i++) {
			if(nums[i - 1] < nums[i]) {
				cnt = 1;
			} else {
				cnt++;
			}
			max = Math.max(cnt, max);
		}
		
		System.out.println(max);

	}

}

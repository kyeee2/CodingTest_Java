package bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_1037_약수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		int [] nums = new int[N];
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(nums);
		
		if(N == 1) System.out.println(nums[0] * nums[0]);
		else System.out.println(nums[0] * nums[N - 1]);

	}

}

package bj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B2_3040_백설공주와일곱난쟁이 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int c = 0;
	static int [] nums = new int [9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		for(int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		findDwarfs(0, 0, 0);
		System.out.println(c);
		
//		System.out.println(output);

	}

	private static void findDwarfs(int start, int cnt, int bits) {
		if(start == 7) {
			c++;
			int sum = 0, ind = 8, temp = bits;
			while(temp > 0) {
				if((temp & 1) == 1) {
					sum += nums[ind];
					output.append(nums[ind]).append("\n");
				}
				
				ind--;
				temp >>= 1;
			}
			
			ind = 8;
			temp = bits;
			if(sum == 100) {
				while(temp > 0) {
					if((temp & 1) == 1) {
						sum += nums[ind];
						output.append(nums[ind]).append("\n");
					}
					
					ind--;
					temp >>= 1;
				}
			}
			
			return;
		}
		
		for(int i = start; i < 9; i++) {
			findDwarfs(start + 1, cnt + 1, (bits | (1 << i)));
		}
		
	}

}

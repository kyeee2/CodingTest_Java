package bj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_B2_2309_일곱난쟁이 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder outer = new StringBuilder();
	
	static int [] weight = new int [9];
	static int [] temp = new int [7];
	static int [] result = new int [7];

	public static void main(String[] args) throws NumberFormatException, IOException {

		for(int i = 0 ; i < 9; i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(weight);
		
		combination(0, 0, 0);
		
		for(int num: result) {
			outer.append(num).append('\n');
		}
		System.out.println(outer);
	}

	private static void combination(int start, int cnt, int sum) {
		if(sum > 100) {
			return;
		}
		if(cnt == 7) {
			if(sum == 100) {
				result = Arrays.copyOf(temp, temp.length);
			}
			
			return;
		}
		
		for(int i = start; i < 9; i++) {
			temp[cnt] = weight[i];
			combination(i + 1, cnt + 1, sum + weight[i]);
		}
	}
	
}

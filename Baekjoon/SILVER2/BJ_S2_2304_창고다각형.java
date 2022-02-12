package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_2304_창고다각형 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, maxInd, max;
	static int [][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N][2];
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(arr, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

		for(int i = 0; i < N; i++) {
			if(arr[i][1] > max) {
				maxInd = i;
				max = arr[i][1];
			}
		}
		
		int sum = max;
		int ind = 0;
		int m = arr[0][1];
		for(int i = 1; i < maxInd; i++) {
			if(arr[i][1] > m) {
				sum += (arr[i][0] - arr[ind][0]) * m;
				ind = i;
				m = arr[i][1];
			}
		}
		sum += (arr[maxInd][0] - arr[ind][0]) * m;
		
		ind = N - 1;
		m = arr[N - 1][1];
		for(int i = N - 2; i > maxInd; i--) {
			if(arr[i][1] > m) {
				sum += (arr[ind][0] - arr[i][0]) * m;
				ind = i;
				m = arr[i][1];
			}
		}
		sum += (arr[ind][0] - arr[maxInd][0]) * m;
		
		System.out.println(sum);

	}

}

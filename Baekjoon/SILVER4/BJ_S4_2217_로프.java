package bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_S4_2217_로프 {

	/*
	 *  중량이 w인 물체를 들어올릴 때, 각각의 로프에 모두 고르게 w/k 만큼의 중량이 걸리므로
	 *  10, 15 이렇게 두개를 고르면 각각의 로프에 12.5씩 중량이 걸리므로 10킬로 로프가 끊어진다
	 *  따라서 가장 작은 무게 * 로프의 개수 가 최대이다.
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] ropes = new int[N];
		for(int i = 0; i < N; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ropes); // 무게순으로 정렬
		
		int max = -1;
		for(int i = 0; i < N; i++) {
			int weight = ropes[i] * (N - i);
			
			if(weight > max) max = weight;
		}
		
		System.out.println(max);

	}

}

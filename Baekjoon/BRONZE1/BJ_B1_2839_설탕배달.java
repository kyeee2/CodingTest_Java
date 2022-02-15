package bj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B1_2839_설탕배달 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		
		int min = 5001;
		boolean flag = true; // 정확하게 N킬로그램을 만들 수 있는가
	
		for(int i = 0; 5 * i <= N ; i++) {
			// 5키로 i개만큼 들기
			int cnt = i;
			int temp = N - 5 * i; // 나머지 킬로그램 계산
			
			// 나머지 3키로로 들 수 있는지 판단
			if(temp % 3 != 0) continue;
			cnt += temp / 3;
			
			if(cnt < min) min = cnt;
		}
		
		if(min != 5001) System.out.println(min); // min 값이 갱신됐다면 최솟값 출력
		else     System.out.println(-1);		 // min 값이 갱신되지 않았다면 -1
	}

}

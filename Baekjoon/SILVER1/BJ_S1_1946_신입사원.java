package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_1946_신입사원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int [][] scores = new int [N][2];
			for(int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				
				scores[i][0] = Integer.parseInt(tokens.nextToken());
				scores[i][1] = Integer.parseInt(tokens.nextToken());
			}
			// 입력 완료
			
			Arrays.sort(scores, (s1, s2) -> Integer.compare(s1[0], s2[0]));
			
			int cnt = 1;
			int score = scores[0][1];
			for(int i = 1; i < N; i++) {
				if(score > scores[i][1]) {
					score = scores[i][1];
					cnt++;					
				}
			}
			
			output.append(cnt).append('\n');
		}
		
		System.out.println(output);
	}

}

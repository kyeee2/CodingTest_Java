package bj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B2_13300_방배정 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		
		int [][] stu = new int [7][2]; // 1 ~ 6학년 녀/남
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(tokens.nextToken());
			int Y = Integer.parseInt(tokens.nextToken());
			
			stu[Y][gender]++;
		}
		
		int cnt = 0; // 방의 개수
		for(int i = 1; i <= 6; i++) {
			for(int j = 0; j < 2; j++) {
				cnt += stu[i][j] / K;
				if(stu[i][j] % K != 0) cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}

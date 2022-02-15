package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_1244_스위치켜고끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine()); // 스위치 수
		int [] switches = new int [N + 1];
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine()); // 학생 수
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int gender = Integer.parseInt(tokens.nextToken()); // 학생의 성별
			int num = Integer.parseInt(tokens.nextToken()); // 학생이 받은 수
			
			if(gender == 1) { // 남학생
				for(int j = num; j <= N; j += num) {
					switches[j] = (switches[j] + 1) % 2;
				}
			} else { // 여학생
				switches[num] = (switches[num] + 1) % 2;
				for(int s = num - 1, e = num + 1; s >= 1 && e <= N; s--, e++) {
					if(switches[s] == switches[e]) {
						switches[s] = (switches[s] + 1) % 2;
						switches[e] = (switches[e] + 1) % 2;
					} else {
						break;
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			output.append(switches[i]).append(" ");
			if(i % 20 == 0) output.append("\n");
		}
		System.out.println(output);

	}

}

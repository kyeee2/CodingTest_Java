package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		boolean flag = false; // -를 만났는가?
		if(str.charAt(0) == '-') {
			flag = true;
		}
		
		int sum = 0;
		StringTokenizer tokens = new StringTokenizer(str, "-"); // '-' 기준으로 나누기
		if(!flag) { // 아직 '-'를 만나지 않았다면
			StringTokenizer temp = new StringTokenizer(tokens.nextToken(), "+"); // '+' 기준으로 나누기
			while(temp.hasMoreTokens()) {
				sum += Integer.parseInt(temp.nextToken());
			}
		}
		
		// 여기부터는 '-'를 만난 이후이다
		while(tokens.hasMoreTokens()) {
			StringTokenizer temp = new StringTokenizer(tokens.nextToken(), "+"); // '+' 기준으로 나누기
			while(temp.hasMoreTokens()) {
				sum -= Integer.parseInt(temp.nextToken());
			}
		}
		
		System.out.println(sum);
	}

}

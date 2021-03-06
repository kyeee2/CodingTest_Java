package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B2_10808_알파벳개수 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		int [] alp = new int[26];
		
		for(int i = 0; i < S.length(); i++) {
			int n = S.charAt(i) - 'a';
			
			alp[n]++;
		}
		
		for(int n: alp) {
			System.out.print(n + " ");
		}
	}

}

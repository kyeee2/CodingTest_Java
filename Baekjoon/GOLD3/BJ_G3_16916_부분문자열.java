import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_G3_16916_부분문자열 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static String P, S;
	static int [] table;

	public static void main(String[] args) throws IOException {
		P = br.readLine();
		S = br.readLine();
		
		System.out.println(KMP());
	}

	private static int KMP() {
		makeTable();
		
		int lenP = P.length(), lenS = S.length();
		int j = 0;
		for(int i = 0; i < lenP; i++) {
			while(j > 0 && P.charAt(i) != S.charAt(j)) {
				j = table[j - 1];
			}
			
			if(P.charAt(i) == S.charAt(j)) {
				if(j == lenS - 1) {
					return 1;
				} else {
					j++;
				}
			}
		}
		return 0;
	}

	private static void makeTable() {
		int len = S.length();
		table = new int [len];
		int j = 0;
		for(int i = 1; i < len; i++) {
			while(j > 0 && S.charAt(i) != S.charAt(j)) {
				j = table[j - 1];
			}
			
			if(S.charAt(i) == S.charAt(j)) {
				table[i] = ++j;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_P5_1786_찾기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static String P, S;
	static int [] table;
	static int cnt;

	public static void main(String[] args) throws IOException {
		P = br.readLine();
		S = br.readLine();
		
		KMP();
		
		System.out.println(cnt);
		System.out.println(output);
	}

	private static void KMP() {
		makeTable();
		
		int lenP = P.length(), lenS = S.length();
		int idx = 0;
		for(int i = 0; i < lenP; i++) {
			while(idx > 0 && P.charAt(i) != S.charAt(idx)) {
				idx = table[idx - 1];
			}
			
			if(P.charAt(i) == S.charAt(idx)) {
				if(idx == lenS - 1) {
					cnt++;
					output.append((i - lenS + 2) + " ");
					idx = table[idx];
				} else {
					idx++;
				}
			}
		}
	}

	private static void makeTable() {
		int len = S.length();
		table = new int [len];
		
		int idx = 0;
		for(int i = 1; i < len; i++) {
			while(idx > 0 && S.charAt(i) != S.charAt(idx)) {
				idx = table[idx - 1];
			}
			
			if(S.charAt(i) == S.charAt(idx)) {
				table[i] = ++idx;
			}
		}
	}

}

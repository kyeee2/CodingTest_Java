import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S1_17609_회문 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int T;
	static String word;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			word = br.readLine();
			output.append(isPossible(0, word.length() - 1, 0) + "\n");
		}
		
		System.out.println(output);
	}

	private static int isPossible(int st, int end, int cnt) {
		if(cnt == 2) return 2;
		
		while(st <= end) {
			if(word.charAt(st) != word.charAt(end)) {
				int result1 = isPossible(st + 1, end, cnt + 1);
				int result2 = isPossible(st, end - 1, cnt + 1);
				
				return result1 < result2 ? result1 : result2;
			}
			st++;
			end--;
		}
		
		return cnt;
	}

}

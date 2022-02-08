import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_G4_1062_가르침 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, K;
	static String [] words;
	static boolean [] isSelected;
	
	static int totalCnt;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		words = new String[N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			str = str.replace("anta", "").replace("tica", "");
			words[i] = str;
		}

		if(K < 5) { // K가 5개 미만이라면 a, n, t, i, c 가 필요한 anta, tica 를 무조건 만족시킬 수 없다
			System.out.println(0);
			return;
		} else if(K == 26) {
			System.out.println(N);
			return;
		}
		
		isSelected = new boolean[26];
		isSelected['a' - 'a'] = true;
		isSelected['c' - 'a'] = true;
		isSelected['i' - 'a'] = true;
		isSelected['n' - 'a'] = true;
		isSelected['t' - 'a'] = true;
		
		findWord(0, 0);
		
		System.out.println(totalCnt);
	}

	private static void findWord(int start, int ind) {
		if(ind == K - 5) {
			int count = 0; // 읽을 수 있는 글자 수
			for(int i = 0; i < N; i++) {
				boolean flag = true;
				for(int j = 0; j < words[i].length(); j++) {
					if(!isSelected[words[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					count++;
				}
			}
			
			if(count > totalCnt) {
				totalCnt = count;
			}
			
			return;
		}
		
		for(int i = start; i < 26; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				findWord(i + 1, ind + 1); // i + 1 을 start + 1 로 생각해서 시간 초과가 떴다ㅜㅠ
				isSelected[i] = false;
			}
		}
	}
	
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_G4_1593_문자해독 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int lenW, lenS, result;
	static String W, S;
	static Map<Character, Integer> w = new HashMap<>();
	static Map<Character, Integer> s = new HashMap<>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		lenW = Integer.parseInt(tokens.nextToken());
		lenS = Integer.parseInt(tokens.nextToken());
		W = br.readLine();
		S = br.readLine();
		
		for(int i = 0; i < lenW; i++) {
			// W의 단어들 분해!
			char chW = W.charAt(i);
			if(w.containsKey(chW)) {
				w.replace(chW, w.get(chW) + 1);
			} else {
				w.put(chW, 1);
			}
			
			// S의 단어들 분해!
			char chS = S.charAt(i);
			if(s.containsKey(chS)) {
				s.replace(chS, s.get(chS) + 1);
			} else {
				s.put(chS, 1);
			}
		}
		
		result = 0;
		int start = 0, end = lenW - 1;
		while(true) {
			boolean isPossible = true;
			for(char ch: w.keySet()) {
				if(!w.containsKey(ch) || w.get(ch) != s.get(ch)) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) result++;
			
			if(end == lenS - 1) break;
			
			// 가장 왼쪽 문자 지우기
			char ch = S.charAt(start++);
			if(s.get(ch) == 1) {
				s.remove(ch);
			} else {
				s.replace(ch, s.get(ch) - 1);
			}
			
			// 가장 오른쪽 문자 지우기
			ch = S.charAt(++end);
			if(s.containsKey(ch)) {
				s.replace(ch, s.get(ch) + 1);
			} else {
				s.put(ch, 1);
			}
		}
		
		System.out.println(result);
	}

}

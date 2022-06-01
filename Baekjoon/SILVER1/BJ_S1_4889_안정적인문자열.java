import java.io.*;
import java.util.Stack;

public class BJ_S1_4889_안정적인문자열 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		for(int t = 1; ; t++) {
			String str = br.readLine();
			
			if(str.charAt(0) == '-') break;
			
			Stack<Character> S = new Stack<>();
			int cnt = 0;
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(ch == '{') {
					S.push('{');
				} else {
					if(S.isEmpty()) {
						S.push('{');
						cnt++;
					} else {
						S.pop();
					}
				}
			}
			
			if(!S.isEmpty()) {
				cnt += S.size() / 2;
			}
			output.append(t + ". " + cnt + "\n");
		}
		System.out.println(output);
	}

}

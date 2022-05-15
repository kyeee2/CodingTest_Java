import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_S4_9012_괄호 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int T;
	static String line;
	static Stack<Character> S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		out : for(int t = 0; t < T; t++) {
			line = br.readLine();
			S = new Stack<>();
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == '(') {
					S.push('(');
				} else if(line.charAt(i) == ')') {
					if(S.isEmpty()) {
						output.append("NO\n");
						continue out;						
					} else {
						S.pop();
					}
				}
			}
			
			if(S.isEmpty()) output.append("YES\n");
			else output.append("NO\n");
		}
		System.out.println(output);
	}

}

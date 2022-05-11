import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S3_17413_단어뒤집기2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static String S;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		S = br.readLine();
		
		int idx = 0;
		boolean reverse = true;
		while(idx < S.length()) {
			if(S.charAt(idx) == '<') {
				while(!stack.isEmpty()) {
					output.append(stack.pop());
				}
				output.append("<");
				reverse = false;
			} else if(S.charAt(idx) == '>') {
				output.append(">");
				reverse = true;
			} else if(!reverse) {
				output.append(S.charAt(idx));
			} else {
				if(S.charAt(idx) == ' ') {
					while(!stack.isEmpty()) {
						output.append(stack.pop());
					}
					output.append(" ");
				} else {
					stack.add(S.charAt(idx));
				}
			}
			
			idx++;
		}
		while(!stack.isEmpty()) {
			output.append(stack.pop());
		}
		
		System.out.println(output);
	}

}

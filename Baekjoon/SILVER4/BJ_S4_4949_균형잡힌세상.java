import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_S4_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		String str = "";
		while(!(str = br.readLine()).equals(".")) {
			Stack<Character> stack = new Stack<>();
			
			boolean flag = true;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					stack.push('(');
				} else if(str.charAt(i) == '[') {
					stack.push('[');
				} else if(str.charAt(i) == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						flag = false;
						break;
					} 
					stack.pop();
				} else if(str.charAt(i) == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						flag = false;
						break;
					} 
					stack.pop();
				}
			} // end for
			
			if(!flag || !stack.isEmpty()) output.append("no\n");
			else 	 output.append("yes\n");
			
		} // end while
		
		System.out.println(output);

	} // end main

}

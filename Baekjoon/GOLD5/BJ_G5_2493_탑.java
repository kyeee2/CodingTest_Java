import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder outer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int [] nums = new int[N];
		int [] result = new int[N];
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Stack<Integer> top = new Stack<>();
		for(int i = 0; i < N; i++) {
			
			while(!top.isEmpty() && (nums[top.peek()] <= nums[i])) {
				top.pop();
			}
			
			if(top.isEmpty()) {
				result[i] = 0;
			} else {
				result[i] = top.peek() + 1;
			}
			
			top.push(i);
		}
		
		while(!top.isEmpty()) {
			top.pop();
		}
		
		for(int i = 0; i < N; i++) {
			outer.append(result[i]).append(" ");
		}
		
		System.out.println(outer);
	}

}

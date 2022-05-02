import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_G5_5430_AC {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	// 덱 활용하지 않는 방법
	static int T, N, st, end;
	static boolean order;
	static String command;
	static int [] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		tc: for(int t = 0; t < T; t++) {
			command = br.readLine();
			N = Integer.parseInt(br.readLine());			
			tokens = new StringTokenizer(br.readLine(), "[],");
			nums = new int [N];
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(tokens.nextToken());
			}
			
			order = true; // 앞에서부터!
			st = 0;
			end = N - 1;
			for(int i = 0; i < command.length(); i++) {
				switch(command.charAt(i)) {
				case 'R':
					if(order) order = false;
					else	  order = true;
					break;
				case 'D':
					// 비어있는 경우 에러
					if(st > end) {
						output.append("error\n");
						continue tc;
					}
					
					if(order) { // 앞에서 제거
						st++;
					} else { // 뒤에서 제거
						end--;
					}
					break;
				}
			}
			
			output.append("[");
			if(order) {
				for(int i = st; i <= end; i++) {
					if(i != st) output.append(",");
					output.append(nums[i]);
				}
			} else {
				for(int i = end; i >= st; i--) {
					if(i != end) output.append(",");
					output.append(nums[i]);
				}
			}
			output.append("]\n");
		}
		System.out.println(output);
	}

	// 덱 활용하는 방법
	/*
	static int T, N, dir;
	static String command;
	static Deque<Integer> nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		tc: for(int t = 0; t < T; t++) {
			command = br.readLine();
			N = Integer.parseInt(br.readLine());			
			String temp = br.readLine();
			tokens = new StringTokenizer(temp.substring(1, temp.length() - 1), ",");
			nums = new ArrayDeque<>();
			for(int i = 0; i < N; i++) {
				nums.add(Integer.parseInt(tokens.nextToken()));
			}
			
			dir = 1; // 앞에서부터!
			for(int i = 0; i < command.length(); i++) {
				switch(command.charAt(i)) {
				case 'R':
					dir *= -1;
					break;
				case 'D':
					// 비어있는 경우 에러
					if(nums.isEmpty()) {
						output.append("error\n");
						continue tc;
					}
					
					if(dir == 1) { // 앞에서 제거
						nums.removeFirst();
					} else { // 뒤에서 제거
						nums.removeLast();
					}
					break;
				}
			}
			
			output.append("[");
			if(dir == 1) {
				int size = nums.size();
				for(int i = 0; i < size; i++) {
					if(i > 0) output.append(",");
					output.append(nums.pollFirst());
				}
			}
			else {
				int size = nums.size();
				for(int i = 0; i < size; i++) {
					if(i > 0) output.append(",");
					output.append(nums.pollLast());
				}
			}
			output.append("]\n");
		}
		System.out.println(output);
	}
*/
	
}

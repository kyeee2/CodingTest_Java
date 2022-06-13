import java.io.*;
import java.util.*;

public class BJ_S1_14225_부분수열의합 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int [] nums;
	static Set<Integer> set = new TreeSet<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		makeSum(0, 0);
		
		int n = 1;
		for(int num: set) {
			if(num != n) {
				break;
			}
			n++;
		}
		System.out.println(n);
	}

	private static void makeSum(int i, int sum) {
		if(i == N) {
			if(sum > 0) set.add(sum);
			return;
		}
		
		makeSum(i + 1, sum);
		makeSum(i + 1, sum + nums[i]);
	}
}

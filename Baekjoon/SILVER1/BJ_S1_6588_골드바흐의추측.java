import java.io.*;
import java.util.*;

public class BJ_S1_6588_골드바흐의추측 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, max;
	static List<Integer> nums = new ArrayList<>();
	static boolean [] notPrime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) break;
			
			nums.add(num);
			N++;
			max = Math.max(max, num);
		}
		
		notPrime = new boolean [max + 1];
		checkPrime();
		
		for(int i = 0; i < N; i++) {
			boolean flag = true;
			for(int j = 3; j <= nums.get(i) / 2; j += 2) {
				if(!notPrime[j] && !notPrime[nums.get(i)  - j]) {
					output.append(String.format("%d = %d + %d\n", nums.get(i), j, nums.get(i) - j));
					flag = false;
					break;
				}
			}
			if(flag) output.append("Goldbach's conjecture is wrong.\n");
		}
		System.out.println(output);
	}

	private static void checkPrime() {
		for(int num = 2; num <= max; num++) {
			if(notPrime[num]) continue;
			if(isPrime(num)) {
				for(int i = 2 * num; i <= max; i += num) {
					notPrime[i] = true;
				}
			}
		}
	}

	private static boolean isPrime(int num) {
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}

}

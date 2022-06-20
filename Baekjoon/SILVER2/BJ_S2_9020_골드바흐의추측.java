import java.io.*;
import java.util.*;

public class BJ_S2_9020_골드바흐의추측 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int T, max;
	static int [] nums;
	static boolean [] prime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		nums = new int [T];
		max = 0;
		for(int i = 0; i < T; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, nums[i]);
		}
		
		prime = new boolean [max + 1];
		checkPrime();
		
		for(int t = 0; t < T; t++) {
			for(int i = nums[t] / 2; i >= 2; i--) {
				if(!prime[i] && !prime[nums[t] - i]) {					
					output.append(i + " " + (nums[t] - i) + "\n");
					break;
				}
			}
		}
		
		System.out.println(output);
	}

	private static void checkPrime() {
		for(int i = 2; i <= max; i++) {
			if(!prime[i] && isPrime(i)) {
				for(int j = 2 * i; j <= max; j += i) {
					prime[j] = true;
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

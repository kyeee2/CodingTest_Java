import java.io.*;

public class BJ_S2_17103_골드바흐파티션 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int T, N, max = -1;
	static int [] nums, prime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		nums = new int [T];
		for(int t = 0; t < T; t++) {
			nums[t] = Integer.parseInt(br.readLine());
			if(max < nums[t]) max = nums[t];
		}
		
		prime = new int [max + 1];
		checkPrime();
		
		for(int t = 0; t < T; t++) {
			int cnt = 0;
			for(int i = 2; i <= nums[t] / 2; i++) {
				if(prime[i] == 1 && (prime[nums[t] - i]) == 1) cnt++;
			}
			
			output.append(cnt + "\n");
		}
		System.out.println(output);
	}

	private static void checkPrime() {
		for(int i = 2; i <= max; i++) {
			if(prime[i] == -1) continue;
			if(isPrime(i)) {
				prime[i] = 1;
				for(int j = 2 * i; j <= max; j += i) {
					prime[j] = -1;
				}
			}
		}
	}

	private static boolean isPrime(int num) {
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

}

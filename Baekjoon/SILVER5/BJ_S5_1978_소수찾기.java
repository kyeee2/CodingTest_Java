import java.io.*;
import java.util.*;

public class BJ_S5_1978_소수찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, max;
	static int [] nums;
	static boolean [] notPrime;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
			max = Math.max(max, nums[i]);
		}
		
		notPrime = new boolean [max + 1];
		notPrime[0] = true;
		notPrime[1] = true;
		
		for(int i = 2; i <= max; i++) {
			if(isPrime(i)) {
				for(int j = 2 * i; j <= max; j += i) {
					notPrime[j] = true;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(!notPrime[nums[i]]) cnt++;
		}
		
		System.out.println(cnt);
	}

	private static boolean isPrime(int num) {
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}

}

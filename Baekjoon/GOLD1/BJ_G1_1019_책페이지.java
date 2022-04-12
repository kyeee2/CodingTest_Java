import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_G1_1019_책페이지 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static long A, B, place = 1; // 일의 자리수부터 시작
	static long [] nums = new long [10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		A = 1;
		B = Integer.parseInt(br.readLine());
		
		while(A <= B) {
			// A의 끝 수를 0으로 맞춰주기
			while(A % 10 != 0 && A <= B) {
				calc(A);
				A++;
			}
			
			if(A > B) break;
			
			// B의 끝 수를 9으로 맞춰주기
			while(B % 10 != 9 && A <= B) {
				calc(B);
				B--;
			}
			
			long diff = B / 10 - A / 10 + 1;
			for(int i = 0; i < 10; i++) {
				nums[i] += diff * place;
			}
			
			place *= 10;
			A /= 10;
			B /= 10;
		}
		
		for(int i = 0; i < 10; i++) {
			output.append(nums[i] + " ");
		}
		System.out.println(output);
	}

	private static void calc(long num) {
		for(long n = num; n > 0; n /= 10) {
			String str = Long.toString(n);
			int idx = str.charAt(str.length() - 1) - '0';
			nums[idx] += place;
		}
	}

}

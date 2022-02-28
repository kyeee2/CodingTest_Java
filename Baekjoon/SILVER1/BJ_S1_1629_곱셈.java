import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_1629_곱셈 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static long A, B, C;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		A = Long.parseLong(tokens.nextToken());
		B = Long.parseLong(tokens.nextToken());
		C = Long.parseLong(tokens.nextToken());
		
		System.out.println(multiplication(A, B, C));
	}

	private static long multiplication(long a, long b, long m) {
		if(b == 1) return a % m;
		
		long val = multiplication(a, b / 2, m);
		val = val * val % m;
		if(b % 2 == 0) return val;
		else return val * a % m;
	}
}

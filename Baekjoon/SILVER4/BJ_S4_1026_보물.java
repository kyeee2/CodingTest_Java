import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_1026_보물 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int [] A, B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		A = new int [N];
		B = new int [N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int sum = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i = 0; i < N; i++) {
			sum += A[i] * B[N - i - 1];
		}
		
		System.out.println(sum);
	}

}

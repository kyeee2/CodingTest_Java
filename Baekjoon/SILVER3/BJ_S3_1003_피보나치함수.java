import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_1003_피보나치함수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N;
	static int [] zeros, ones;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			zeros = new int [N + 1];
			ones = new int [N + 1];
			
			if(N == 0) {
				output.append(1 + " " + 0 + "\n");
				continue;
			} else if(N == 1) {
				output.append(0 + " " + 1 + "\n");
				continue;
			}
			
			zeros[0] = 1;
			zeros[1] = 0;
			ones[0] = 0;
			ones[1] = 1;
			
			for(int i = 2; i <= N; i++) {
				zeros[i] = zeros[i - 1] + zeros[i - 2];
				ones[i] = ones[i - 1] + ones[i - 2];
			}
			
			output.append(zeros[N] + " " + ones[N] + "\n");
		}
		System.out.println(output);
	}

}

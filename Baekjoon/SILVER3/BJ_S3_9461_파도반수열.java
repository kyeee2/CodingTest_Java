import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S3_9461_파도반수열 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int T, N;
	static long [] P;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			P = new long [N + 1];
			
			if(N <= 3) {
				output.append("1\n");
				continue;
			} else if(N <= 5) {
				output.append("2\n");
				continue;
			}
			P[1] = 1;
			P[2] = 1;
			P[3] = 1;
			P[4] = 2;
			P[5] = 2;
			for(int i = 6; i <= N; i++) {
				P[i]= P[i - 1] + P[i - 5];
			}
			
			output.append(P[N] + "\n");
		}
		System.out.println(output);
	}

}

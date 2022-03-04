import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_9372_상근이의여행 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			for(int i = 0; i < M; i++) {
				tokens = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(tokens.nextToken());
				int n2 = Integer.parseInt(tokens.nextToken());
			}
			output.append((N-1) + "\n");
		}
		System.out.println(output);
	}

}

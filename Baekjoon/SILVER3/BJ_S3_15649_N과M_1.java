import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_15649_N과M_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static int [] result;
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		result = new int [M];
	
		permutation(0, 0);
		
		System.out.println(output);
	}

	private static void permutation(int cnt, int bits) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				output.append(result[i]).append(" ");
			}
			output.append("\n");
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((bits & 1 << i) != 0) continue;
			
			result[cnt] = i + 1;
			permutation(cnt + 1, bits | 1 << i);
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_15650_N과M2 {

	
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
		combination(0, 0, 0);
		
		System.out.println(output);
	}

	private static void combination(int cnt, int start, int bits) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				output.append(result[i] + " ");
			}
			output.append('\n');
			return;
		}
		
		for(int i = start; i < N; i++) {
			if((bits & 1 << i) != 0) continue;
			
			result[cnt] = i + 1;
			combination(cnt + 1, i + 1, bits | 1 << i);
		}
	}

}

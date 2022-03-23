import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_11659_구간합구하기4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static int [] nums, D;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		nums = new int [N + 1];
		D = new int [N + 1];
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
			D[i] = D[i - 1] + nums[i];
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(tokens.nextToken());
			int e = Integer.parseInt(tokens.nextToken());
			output.append(D[e] - D[s - 1] + "\n");
		}
		System.out.println(output);
	}

}

import java.io.*;
import java.util.*;

public class BJ_G5_2230_수고르기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int M;
	static int [] A;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		A = new int [N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(A);
		
		int idx1 = 0, idx2 = 1;
		int min = Integer.MAX_VALUE;
		while(idx1 < N && idx2 < N) {
			int diff = A[idx2] - A[idx1];
			
			if(diff < M) {
				idx2++;
				continue;
			} 
			if(diff == M) {
				min = diff;
				break;
			}
			min = Math.min(min, diff);
			idx1++;
		}
		
		System.out.println(min);
	}

}

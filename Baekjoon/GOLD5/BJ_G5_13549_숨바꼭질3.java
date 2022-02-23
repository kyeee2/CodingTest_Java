import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_13549_숨바꼭질3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K;
	static int [] arr = new int [200001];

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(N);
		Arrays.fill(arr, -1);
		arr[N] = 0;
		
		while(!Q.isEmpty()) {
			int n = Q.poll();
			
			if(n == K) {
				System.out.println(arr[K]);
				return;
			}
			 
			if(2 * n <= 200000 && arr[2 * n] == -1) {
				Q.offer(2 * n);
				arr[2 * n] = arr[n];
			}
			if(n - 1 >= 0 && arr[n - 1] == -1) {
				Q.offer(n - 1);
				arr[n - 1] = arr[n] + 1;
			} 
			if(n + 1 <= 200000 && arr[n + 1] == -1) {
				Q.offer(n + 1);
				arr[n + 1] = arr[n] + 1;
			}
		}
	}

}

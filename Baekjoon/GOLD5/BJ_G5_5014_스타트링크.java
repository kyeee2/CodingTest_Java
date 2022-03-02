import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_5014_스타트링크 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int F, S, G, U, D, result = -1;
	static int [] count;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		F = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		G = Integer.parseInt(tokens.nextToken());
		U = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		
		count = new int [F+ 1];
		Arrays.fill(count, -1);
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(S);
		count[S] = 0; // 시작 층
		
		while(!Q.isEmpty()) {
			int s = Q.poll();
			
			if(s == G) {
				System.out.println(count[s]);
				return;
			}
			
			if(s + U <= F && count[s + U] == -1) {
				Q.offer(s + U);
				count[s + U] = count[s] + 1;				
			}
			if(1 <= s - D && count[s - D] == -1) {
				Q.offer(s - D);
				count[s - D] = count[s] + 1;
			}
		}
		
		System.out.println("use the stairs");
	}
}

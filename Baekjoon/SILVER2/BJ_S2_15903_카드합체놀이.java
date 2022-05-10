import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_S2_15903_카드합체놀이 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static PriorityQueue<Long> pQ = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pQ.offer(Long.parseLong(tokens.nextToken()));
		}
		
		for(int i = 0; i < M; i++) {
			long n1 = pQ.poll();
			long n2 = pQ.poll();
			
			pQ.offer(n1 + n2);
			pQ.offer(n1 + n2);
		}
		
		long total = 0;
		while(!pQ.isEmpty()) {
			total += pQ.poll();
		}
		
		System.out.println(total);
	}

}

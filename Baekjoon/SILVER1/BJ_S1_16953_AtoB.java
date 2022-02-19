import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_16953_AtoB {

	static class Number {
		long num;
		int cnt;
		
		public Number(long num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(tokens.nextToken());
		long B = Long.parseLong(tokens.nextToken());
		int min = Integer.MAX_VALUE;
		
		Queue<Number> Q = new LinkedList<>();

		Q.offer(new Number(A, 1));
		while(!Q.isEmpty()) {
			long num = Q.peek().num;
			int cnt = Q.poll().cnt;
			
			if(num == B) {
				if(cnt < min) min = cnt;
			}
			if(num < B) {
				Q.offer(new Number(num * 10L + 1L, cnt + 1));
				Q.offer(new Number(num * 2L, cnt + 1));				
			}
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else 						 System.out.println(min);
	}

}

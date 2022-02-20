import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_1697_숨바꼭질 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K, result;
	static boolean [] ch = new boolean[100001];
	static Queue<Location> Q = new LinkedList<>();
	
	static class Location {
		int x, cnt;
		
		public Location(int x, int c) {
			this.x = x;
			this.cnt = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		Q.add(new Location(N, 0));
		ch[N] = true;
		while(!Q.isEmpty()) {
			int n = Q.peek().x;
			int cnt = Q.poll().cnt;
			
			if(n == K) {
				result = cnt;
				break;
			}
			
			if(isIn(n - 1) && !ch[n - 1]) {
				Q.add(new Location(n - 1, cnt + 1));
				ch[n - 1] = true;
			}
			if(isIn(n + 1) && !ch[n + 1]) {
				Q.add(new Location(n + 1, cnt + 1));
				ch[n + 1] = true;
			}
			if(isIn(n * 2) && !ch[n * 2]) {
				Q.add(new Location(n * 2, cnt + 1));
				ch[n * 2] = true;
			}
		}
		
		System.out.println(result);

	}

	private static boolean isIn(int n) {
		return n >= 0 && n <= 100000;
	}

}

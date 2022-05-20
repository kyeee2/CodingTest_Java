import java.io.*;
import java.util.*;

public class BJ_G5_11590_풍선맞추기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, result;
	static int [] balloon;
	static boolean [] visited;
	static PriorityQueue<Balloon> pQ = new PriorityQueue<>();
	
	static class Balloon implements Comparable<Balloon> {
		int height, idx;
		
		public Balloon(int h, int i) {
			this.height = h;
			this.idx = i;
		}

		@Override
		public int compareTo(Balloon o) {
			return Integer.compare(this.height, o.height) * -1;
		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		balloon = new int [N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			balloon[i] = Integer.parseInt(tokens.nextToken());
			pQ.offer(new Balloon(balloon[i], i));
		}

		visited = new boolean [N];
		int cnt = 0; // 터진 풍선 개수
		while(!pQ.isEmpty()) {
			int h = pQ.peek().height;
			int idx = pQ.poll().idx;
			
			if(visited[idx]) continue;
			result++;
			
			for(int i = idx; i < N; i++) {
				if(balloon[i] == h && !visited[i]) {
					h--;
					cnt++;
					visited[i] = true;
				}
				if(h == 0) break;
			}
			
			// 풍선 다 터뜨린 경우
			if(cnt == N) break;
		}
		
		System.out.println(result);
	}

}

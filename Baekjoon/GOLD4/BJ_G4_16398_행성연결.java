import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_16398_행성연결 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int [][] map;
	static boolean [] visited;

	static class Point implements Comparable<Point>{
		int vertex, cost;
		
		public Point(int v, int c) {
			this.vertex = v;
			this.cost = c;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for(int r = 0; r < N; r++) {
			tokens= new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		PriorityQueue<Point> Q = new PriorityQueue<>();
		Q.offer(new Point(0, 0));
		visited = new boolean [N];
		int total = 0;
		
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			
			if(visited[now.vertex]) continue;
			
			visited[now.vertex] = true;
			total += now.cost;
			
			for(int i = 0; i < N; i++) {
				if(map[now.vertex][i] == 0 || visited[i]) continue;
				
				Q.offer(new Point(i, map[now.vertex][i]));
			}
		}
		
		System.out.println(total);
	}

}

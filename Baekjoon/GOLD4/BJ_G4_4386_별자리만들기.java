import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_4386_별자리만들기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static double [][] points, map;
	static boolean [] visited;
	
	static class Point implements Comparable<Point> {
		int vertex;
		double cost;
		
		public Point(int v, double c) {
			this.vertex = v;
			this.cost = c;
		}

		@Override
		public int compareTo(Point o) {
			return Double.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		points = new double [N][2];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			points[i][0] = Double.parseDouble(tokens.nextToken());
			points[i][1] = Double.parseDouble(tokens.nextToken());
		}
		
		map = new double [N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <N; j++) {
				if(i == j) continue;
				
				double x = points[i][0] - points[j][0];
				double y = points[i][1] - points[j][1];
				map[i][j] = Math.sqrt(x * x + y * y);
			}
		}

		PriorityQueue<Point> pQ = new PriorityQueue<>();
		visited = new boolean [N];
		
		pQ.add(new Point(0, 0));
		
		double total = 0.;
		while(!pQ.isEmpty()) {
			Point now = pQ.poll();
			
			if(visited[now.vertex]) continue;
			
			visited[now.vertex] = true;
			total += now.cost;
			
			for(int i = 0; i < N; i++) {
				if(map[now.vertex][i] == 0 || visited[i]) continue;
				
				pQ.add(new Point(i, map[now.vertex][i]));
			}
		}
		
		System.out.println(String.format("%.2f", total));
	}

}

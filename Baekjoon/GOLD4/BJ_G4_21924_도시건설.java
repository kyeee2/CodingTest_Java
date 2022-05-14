import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_21924_도시건설 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static List<List<Node>> graph = new ArrayList<>();
	
	static class Node implements Comparable<Node> {
		int vertex, cost;
		
		public Node(int v, int c) {
			this.vertex = v;
			this.cost = c;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		// 그래프 그리기
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		long total = 0;
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(tokens.nextToken());
			int v2 = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			
			total += c;
			graph.get(v1).add(new Node(v2, c));
			graph.get(v2).add(new Node(v1, c));
		}
		
		long sum = 0, cnt = 0;
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		boolean [] visited = new boolean [N + 1];
		
		pQ.offer(new Node(1, 0));
		
		while(!pQ.isEmpty()) {
			Node now = pQ.poll();
			
			if(visited[now.vertex]) continue;
			
			visited[now.vertex] = true;
			sum += now.cost;
			if(++cnt == N) break;
			
			for(int i = 0; i < graph.get(now.vertex).size(); i++) {
				int v = graph.get(now.vertex).get(i).vertex;
				int c = graph.get(now.vertex).get(i).cost;
				
				if(visited[v]) continue;
				pQ.offer(new Node(v, c));
			}
		}
		
		if(cnt != N) System.out.println(-1);
		else System.out.println(total - sum);
	}

}

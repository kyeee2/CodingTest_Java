import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_1197_최소스패닝트리 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int V, E;
	static int [] p;
	static PriorityQueue<Edge> pQ = new PriorityQueue<>((e1, e2) -> Long.compare(e1.weight, e2.weight));
	
	static class Edge {
		int node1, node2;
		long weight;
		
		public Edge(int n1, int n2, long w) {
			this.node1 = n1;
			this.node2 = n2;
			this.weight = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		 
		tokens = new StringTokenizer(br.readLine());
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());

		for(int i= 0; i < E; i++) {
			tokens = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = Integer.parseInt(tokens.nextToken());
			long w = Long.parseLong(tokens.nextToken());
			
			pQ.offer(new Edge(n1, n2, w));
		}
		
		makeSet();
		
		int cnt = 0;
		long total = 0;
		while(cnt < V - 1) {
			Edge edge = pQ.poll();
			
			if(union(edge.node1, edge.node2)) {
				cnt++;
				total += edge.weight;
			}
		}
		
		System.out.println(total);
	}

	private static void makeSet() {
		p = new int [V + 1];
		
		for(int i = 1; i <= V; i++) {
			p[i] = i;
		}
	}

	private static int find(int node) {
		if(node == p[node]) return node;
		else				return p[node] = find(p[node]);
	}
	
	private static boolean union(int node1, int node2) {
		int p1 = find(node1), p2 = find(node2);
		
		if(p1 == p2) return false;
		
		p[p1] = p2;
		return true;
	}

}

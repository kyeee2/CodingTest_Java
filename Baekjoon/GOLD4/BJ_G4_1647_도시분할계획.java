import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_1647_도시분할계획 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static List<List<Node>> graph = new ArrayList<>();
	
	static class Node implements Comparable<Node> {
		int vertex, weight;
		
		public Node(int v, int w) {
			this.vertex = v;
			this.weight = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(tokens.nextToken());
			int v2 = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			
			graph.get(v1).add(new Node(v2, w));
			graph.get(v2).add(new Node(v1, w));
		}
		
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		pQ.offer(new Node(1, 0));
		
		boolean [] visited = new boolean [N + 1];
		int cnt = 0;
		int sum = 0;
		int max = -1;
		while(!pQ.isEmpty()) {
			Node node = pQ.poll();
			
			// 이미 방문한 노드인가?
			if(visited[node.vertex]) continue;
			
			visited[node.vertex] = true;
			sum += node.weight;
			max = Math.max(max, node.weight);
			if(++cnt == N) break; // 다 돌아봄!
			
			for(int i = 0; i < graph.get(node.vertex).size(); i++) {
				int v = graph.get(node.vertex).get(i).vertex;
				int w = graph.get(node.vertex).get(i).weight;
				
				if(visited[v]) continue;
				
				pQ.offer(new Node(v, w));
			}
		}
		
		System.out.println(sum - max);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_17396_백도어 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static boolean [] visited;
	static long [] distance;
	static List<List<Node>> graph = new ArrayList<>();

	static class Node implements Comparable<Node> {
		int vertex;
		long time;
		
		public Node(int vertex, long t) {
			this.vertex = vertex;
			this.time = t;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		visited = new boolean[N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			if(Integer.parseInt(tokens.nextToken()) == 1) {
				visited[i] = true;
			}
		}
		visited[N-1] = false; // 마지막은 방문 가능!
		
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(tokens.nextToken());
			int v2 = Integer.parseInt(tokens.nextToken());
			int t = Integer.parseInt(tokens.nextToken());
			
			graph.get(v1).add(new Node(v2, t));
			graph.get(v2).add(new Node(v1, t));
		}
		
		distance = new long[N];
		Arrays.fill(distance, Long.MAX_VALUE);
		
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		pQ.add(new Node(0, 0));
		distance[0] = 0;
		
		while(!pQ.isEmpty()) {
			int vertex = pQ.poll().vertex;
			
			// 도착!
			if(vertex == N - 1) {
				System.out.println(distance[vertex]);
				return;
			}
			
			// 이미 방문한 노드라면
			if(visited[vertex]) continue;
			
			// 방문처리
			visited[vertex] = true;
			
			// 새로 거리 측정
			for(int i = 0; i < graph.get(vertex).size(); i++) {
				int v = graph.get(vertex).get(i).vertex;
				long t = graph.get(vertex).get(i).time;
				
				if(visited[vertex] && distance[v] > distance[vertex] + t) {
					distance[v] = distance[vertex] + t;
					pQ.add(new Node(v, distance[v]));
				}
			}
		}
		
		System.out.println("-1");
	}

}

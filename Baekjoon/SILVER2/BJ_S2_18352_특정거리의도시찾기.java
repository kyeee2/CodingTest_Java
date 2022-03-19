import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_18352_특정거리의도시찾기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, K, start;
	static List<List<Integer>> graph = new ArrayList<>();
	static int [] dist;
	static boolean [] visited;
	static Queue<Integer> Q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		start = Integer.parseInt(tokens.nextToken());

		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		dist = new int[N + 1];
		visited = new boolean [N + 1];
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(tokens.nextToken());
			int v2 = Integer.parseInt(tokens.nextToken());
			
			graph.get(v1).add(v2);
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Q.offer(start);
		visited[start] = true;
		dist[start] = 0;
		
		while(!Q.isEmpty()) {
			int vertex = Q.poll();
			
			for(int i = 0; i < graph.get(vertex).size(); i++) {
				int v = graph.get(vertex).get(i);
				
				if(visited[v]) continue;
				
				Q.offer(v);
				visited[v] = true;
				dist[v] = dist[vertex] + 1;
			}
		}
		
		boolean flag = true;
		for(int i = 1; i <= N; i++) {
			if(dist[i] == K) {
				flag = false;
				System.out.println(i);
			}
		}
		
		if(flag) System.out.println(-1);
	}

}

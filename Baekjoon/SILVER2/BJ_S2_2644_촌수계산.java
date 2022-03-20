import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S2_2644_촌수계산 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, start, end, result = -1;
	static boolean [] visited;
	static List<List<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		visited = new boolean [N + 1];
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		tokens = new StringTokenizer(br.readLine());
		start = Integer.parseInt(tokens.nextToken());
		end = Integer.parseInt(tokens.nextToken());
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(tokens.nextToken());
			int v2 = Integer.parseInt(tokens.nextToken());
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		
		visited[start] = true;
		dfs(start, 0);
		
		System.out.println(result);
	}

	private static void dfs(int vertex, int cnt) {
		if(vertex == end) {
			result = cnt;
			return;
		}
		
		for(int i = 0; i < graph.get(vertex).size(); i++) {
			if(visited[graph.get(vertex).get(i)]) continue;
			
			visited[graph.get(vertex).get(i)] = true;
			dfs(graph.get(vertex).get(i), cnt + 1);
			visited[graph.get(vertex).get(i)] = false;
		}
	}
}

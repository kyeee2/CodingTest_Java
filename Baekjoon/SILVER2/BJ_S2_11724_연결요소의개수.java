import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_11724_연결요소의개수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	
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
			graph.get(v1).add(v2);
			graph.get(v2).add(v1); // 무방향 그래프
		}
		
		boolean [] visited = new boolean [N + 1];
		Queue<Integer> Q = new LinkedList<Integer>();
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			
			cnt++;
			Q.offer(i);
			visited[i] = true;
			
			while(!Q.isEmpty()) {
				int node = Q.poll();
				
				for(int j = 0; j < graph.get(node).size(); j++) {
					int v = graph.get(node).get(j);
					if(visited[v]) continue;
					
					Q.offer(v);
					visited[v] = true;
				}
			}
		}
		
		System.out.println(cnt);
	}

}

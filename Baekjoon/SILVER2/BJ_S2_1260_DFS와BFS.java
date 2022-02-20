import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_1260_DFS와BFS {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, V;
	static List<List<Integer>> Graph;
	static boolean [] ch;
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 정점의 개수
		M = Integer.parseInt(tokens.nextToken()); // 간선의 개수
		V = Integer.parseInt(tokens.nextToken()); // 시작점
		
		// 그래프 생성
		Graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			Graph.add(new ArrayList<>());
		} 
		// 간선정보 입력
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(tokens.nextToken());
			int v2 = Integer.parseInt(tokens.nextToken());
			
			Graph.get(v1).add(v2);
			Graph.get(v2).add(v1);
		}
		// 간선 오름차순 정렬
		for(int i = 1; i <= N; i++) {
			Collections.sort(Graph.get(i));
		}
		
		ch = new boolean[N + 1];
		ch[V] = true;
		DFS(V);
		output.append('\n');
		ch = new boolean[N + 1];
		BFS(V);
		
		System.out.println(output);
	}

	private static void BFS(int node) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(node);
		ch[node] = true;
		
		while(!Q.isEmpty()) {
			int n = Q.poll();
			output.append(n).append(" ");
			
			for(int i = 0; i < Graph.get(n).size(); i++) {
				int temp = Graph.get(n).get(i);
				if(!ch[temp]) {
					Q.offer(temp);
					ch[temp] = true;
				}
			}
		}
		output.append('\n');
	}

	private static void DFS(int node) {
		output.append(node).append(' ');
		
		for(int i = 0; i < Graph.get(node).size(); i++) {
			int n = Graph.get(node).get(i);
			if(!ch[n]) {
				ch[n] = true;
				DFS(n);
			}
		}
	}
}

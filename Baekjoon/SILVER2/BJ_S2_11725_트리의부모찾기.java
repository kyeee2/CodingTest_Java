import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_11725_트리의부모찾기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int [] p;
	static boolean [] visited;
	static List<List<Integer>> graph = new ArrayList<List<Integer>>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		p = new int [N + 1];
		visited = new boolean [N + 1];
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			p[i] = i;
		}
		
		for(int i = 0; i < N - 1; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = Integer.parseInt(tokens.nextToken());
			
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);			
		}
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(1);
		visited[1] = true;
		
		while(!Q.isEmpty()) {
			int node = Q.poll();
			
			for(int i = 0; i < graph.get(node).size(); i++) {
				int n = graph.get(node).get(i);
				
				if(visited[n]) continue;
				
				p[n] = node;
				Q.offer(n);
				visited[n] = true;
			}
		}
		
		for(int i = 2; i <= N; i++) {
			output.append(p[i]).append("\n");
		}
		System.out.println(output);
	}
}

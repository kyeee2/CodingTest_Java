import java.io.*;
import java.util.*;

public class BJ_G5_13265_색칠하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, M;
	static int [] colors;
	static List<List<Integer>> graph;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			graph = new ArrayList<>();
			for(int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			
			colors = new int [N + 1];
			for(int i = 0; i < M; i++) {
				tokens = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(tokens.nextToken());
				int n2 = Integer.parseInt(tokens.nextToken());
				
				graph.get(n1).add(n2);
				graph.get(n2).add(n1);
			}
			
			flag = true;
			// 색은 1 또는 -1
			for(int i = 1; i <= N; i++) {
				if(colors[i] == 0) {
					colors[i] = 1;
					DFS(i);					
				}
			}
			if(flag) output.append("possible\n");
			else output.append("impossible\n");
		}
		System.out.println(output);
	}

	private static void DFS(int i) {
		for(int j = 0; j < graph.get(i).size(); j++) {
			int n = graph.get(i).get(j);
			
			if(colors[i] == colors[n]) {
				flag = false;
				return;
			} else if(colors[n] == 0) {
				colors[n] = colors[i] * -1;
				DFS(n);
			}
		}
		
	}

}

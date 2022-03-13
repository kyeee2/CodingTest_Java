import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_11403_경로찾기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static boolean [][] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		graph = new boolean [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				if(Integer.parseInt(tokens.nextToken()) == 1) {
					graph[r][c] = true;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			boolean [] visited = new boolean[N];
			Queue<Integer> Q = new LinkedList<Integer>();
			
			for(int j = 0; j < N; j++) {
				if(graph[i][j]) Q.offer(j);
			}
			
			while(!Q.isEmpty()) {
				int v = Q.poll();
				
				if(visited[v]) continue;
				
				visited[v] = true;
				
				for(int j = 0; j < N; j++) {
					if(graph[v][j] && !visited[j]) Q.offer(j);
				}
			}
			
			for(int j = 0; j < N; j++) {
				if(visited[j]) output.append(1 + " ");
				else		   output.append(0 + " ");
			}
			output.append("\n");
		}
		
		System.out.println(output);
	}

}

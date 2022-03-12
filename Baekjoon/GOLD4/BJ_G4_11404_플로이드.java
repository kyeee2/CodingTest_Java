import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_11404_플로이드 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static List<List<Node>> graph = new ArrayList<>();
	
	static class Node {
		int vertex, cost;
		
		public Node(int v, int c) {
			this.vertex = v;
			this.cost = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(tokens.nextToken());
			int v2 = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			
			graph.get(v1).add(new Node(v2, c));
		}
		
		// 다익스트라
		for(int start = 1; start <= N; start++) {
			boolean [] visited = new boolean[N + 1];
			int [] dist = new int [N + 1]; // 최소 거리를 저장할 배열
			for(int i = 1; i <= N; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			
			dist[start] = 0;
			for(int i = 1; i <= N; i++) {
				int nodeValue = Integer.MAX_VALUE;
				int nodeInd = 0;
				
				for(int j = 1; j <= N; j++) {
					if(!visited[j] && dist[j] < nodeValue) {
						nodeValue = dist[j];
						nodeInd = j;
					}
				}
				
				visited[nodeInd] = true;
				
				for(int j = 0; j < graph.get(nodeInd).size(); j++) {
					Node adjNode = graph.get(nodeInd).get(j);
					
					if(dist[adjNode.vertex] > dist[nodeInd] + adjNode.cost) {
						dist[adjNode.vertex] = dist[nodeInd] + adjNode.cost;
					}
				}
			}
			
			for(int i = 1; i <= N; i++) {
				if(dist[i] == Integer.MAX_VALUE) {
					output.append("0 ");
				} else {
					output.append(dist[i] + " ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}

}

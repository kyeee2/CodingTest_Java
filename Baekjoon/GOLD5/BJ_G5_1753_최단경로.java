import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_1753_최단경로 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int V, E, K;
	static List<List<Point>> graph;
	static int [] distance;
	static boolean [] visited;
	
	static class Point {
		int vertex, weight;
		
		public Point(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		} 
	}
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<List<Point>>();
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(tokens.nextToken());
			int v2 = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			
			graph.get(v1).add(new Point(v2, w));
		}
		
		distance = new int [V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		visited = new boolean[V + 1];
		
		distance[K] = 0; // 시작점
		
		for(int i = 0; i < V; i++) {
			// 가장 짧은 길이 위치 구하기
			int min = Integer.MAX_VALUE, ind = 0;
			for(int j = 1; j <= V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					ind = j;
				}
			}
			
			// 최소신장트리에 추가
			visited[ind] = true;
			
			// 최소 거리 업데이트
			for(int j = 0; j < graph.get(ind).size(); j++) {
				int v = graph.get(ind).get(j).vertex;
				if(!visited[v] && distance[v] > distance[ind] + graph.get(ind).get(j).weight) {
					distance[v] = distance[ind] + graph.get(ind).get(j).weight;
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				output.append("INF");
			} else {
				output.append(distance[i]);
			}
			output.append('\n');
		}
		System.out.println(output);

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_1916_최소비용구하기 {

		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringBuilder output = new StringBuilder();
		static StringTokenizer tokens;
		
		static int N, M, start, end, result;
		static boolean [] visited;
		static List<List<Point>> graph = new ArrayList<>();
		
		static class Point implements Comparable<Point> {
			int vertex, weight;
			
			public Point(int vertex, int weight) {
				this.vertex = vertex;
				this.weight = weight;
			}

			@Override
			public int compareTo(Point o) {
				return Integer.compare(this.weight, o.weight);
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
				int w = Integer.parseInt(tokens.nextToken());
				
				graph.get(v1).add(new Point(v2, w));
			}

			tokens = new StringTokenizer(br.readLine());
			start = Integer.parseInt(tokens.nextToken());
			end = Integer.parseInt(tokens.nextToken());
			
			// 최단경로 저장
			int [] distance = new int [N + 1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			visited = new boolean [N + 1];
			
			distance[start] = 0;
			PriorityQueue<Point> pQ = new PriorityQueue<>();
			pQ.add(new Point(start, 0));
			
			while(!pQ.isEmpty()) {
				Point current = pQ.poll();
				
				// 원하는 점
				if(current.vertex == end) {
					System.out.println(distance[current.vertex]);
					return;
				}
				
				// 이미 방문한 점이라면
				if(visited[current.vertex]) continue;
				
				// 방문처리
				visited[current.vertex] = true;
				
				for(int i = 0; i < graph.get(current.vertex).size(); i++) {
					int v = graph.get(current.vertex).get(i).vertex;
					int w = graph.get(current.vertex).get(i).weight;
					
					if(!visited[v] && distance[v] > distance[current.vertex] + w) {
						distance[v] = distance[current.vertex] + w;
						pQ.offer(new Point(v, distance[v]));
					}
				}
			}

	}

}

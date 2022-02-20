import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S3_2606_바이러스 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine()); // 컴퓨터수
		int M = Integer.parseInt(br.readLine()); // 간선의수

		List<List<Integer>> computers = new ArrayList<>();
		for(int i = 0 ; i<= N; i++) {
			computers.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = Integer.parseInt(tokens.nextToken());
			computers.get(n1).add(n2);
			computers.get(n2).add(n1);
		}
		
		// BFS
		Queue<Integer> Q = new LinkedList<Integer>();
		boolean [] ch = new boolean [N + 1];
		Q.offer(1); // 1번 컴퓨터 감염
		ch[1] = true;
		int cnt = -1; // 감염된 컴퓨터 개수, 1번 컴퓨터는 제외
		
		while(!Q.isEmpty()) {
			cnt++;
			int node = Q.poll();
			
			for(int i = 0; i < computers.get(node).size(); i++) {
				int n = computers.get(node).get(i);
				
				if(!ch[n]) {
					Q.offer(n);
					ch[n] = true;
				}
			}
		}
		
		System.out.println(cnt);
	}

}

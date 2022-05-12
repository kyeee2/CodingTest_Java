import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_3584_가장가까운공통조상 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N;
	static int [] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			parent = new int [N + 1];
			// 부모 초기화
			for(int i = 0; i <= N; i++) {
				parent[i] = i;
			}
			
			// 부모 설정해주기
			for(int i = 0; i < N - 1; i++) {
				tokens = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(tokens.nextToken());
				int B = Integer.parseInt(tokens.nextToken());
				parent[B] = A; // B의 부모가 A
			}
			
			tokens = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			
			boolean [] visited = new boolean [N + 1];

			// u부터 루트까지 모든 노드를 방문체크 해주기
			visited[u] = true;
			while(u != parent[u]) { // 루트까지 올라가기
				u = parent[u];
				visited[u] = true;
			}
			
			while(true) { // v != visited[v] 가 되면 루트가 가장 가까운 공통 조상이 될 수 없다!
				if(visited[v]) {
					output.append(v + "\n");
					break;
				}
				
				v = parent[v];
			}
		}
		
		System.out.println(output);
	}

}

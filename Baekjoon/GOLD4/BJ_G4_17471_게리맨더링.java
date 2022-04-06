import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_17471_게리맨더링 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, min = Integer.MAX_VALUE;
	static int [] nums;
	static List<List<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		nums = new int [N + 1];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			for(int j = 0; j < n; j++) {
				int v = Integer.parseInt(tokens.nextToken());
				
				graph.get(i).add(v);
			}
		}
		
		solution(0, 0);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else 						 System.out.println(min);
	}

	private static void solution(int cnt, int bits) {
		if(cnt == N) {
			if(isPossible(bits)) {
				int sumA = 0;
				int sumB = 0;
				for(int i = 0; i < N; i++) {
					if((bits & 1 << i) != 0) sumA += nums[i + 1];
					else					 sumB += nums[i + 1];
				}
				
				min = Math.min(min, Math.abs(sumA - sumB));
			}
			return;
		}

		solution(cnt + 1, bits);
		solution(cnt + 1, bits | 1 << cnt);
	}

	// 선거구역이 공평하게 나뉘어있는지 체크
	private static boolean isPossible(int bits) {
		List<Integer> A = new ArrayList<>(); // 선거구역 A
		List<Integer> B = new ArrayList<>(); // 선거구역 B
		
		for(int i = 0; i < N; i++) {
			if((bits & 1 << i) != 0) A.add(i + 1);
			else					 B.add(i + 1);
		}
		
		// 선거구가 하나의 구역만 포함한 경우
		if(A.size() == 0 || B.size() == 0) return false;
		
		// 선거구가 연결되지 않은 경우
		if(!isConnected(A)) return false;
		if(!isConnected(B)) return false;
		
		return true;
	}

	// 구역이 연결 되어있는지 체크
	private static boolean isConnected(List<Integer> list) {
		boolean [] visited = new boolean [N + 1];
		Queue<Integer> Q = new LinkedList<>();
		
		// 구역이 연결 되었는지 확인
		Q.add(list.get(0));
		visited[list.get(0)] = true;
		
		int cnt = 1;
		while(!Q.isEmpty()) {
			int v = Q.poll();
			
			for(int i = 0; i < graph.get(v).size(); i++) {
				int v2 = graph.get(v).get(i);
				
				if(visited[v2] || !list.contains(v2)) continue;
				
				Q.add(v2);
				visited[v2] = true;
				cnt++;
			}
		}
		
		if(list.size() == cnt) return true;
		else				   return false;
	}
}

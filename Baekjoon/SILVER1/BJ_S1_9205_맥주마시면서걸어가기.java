import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_9205_맥주마시면서걸어가기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N;
	static int [][] place;
	static boolean [][] connected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			place = new int [N + 2][2];
			for(int i = 0; i < N + 2; i++) {
				tokens = new StringTokenizer(br.readLine());
				place[i][0] = Integer.parseInt(tokens.nextToken());
				place[i][1] = Integer.parseInt(tokens.nextToken());
			}

			// 갈 수 있는 곳 연결 해주기
			connected = new boolean [N + 2][N + 2];
			for(int i = 0; i < N + 2; i++) {
				for(int j = 0; j < N + 2; j++) {
					if(Manhattan(place[i], place[j]) <= 1000) {
						connected[i][j] = true;
						connected[j][i] = true;
					}
				}
			}
			
			output.append(BFS());
		}
		System.out.println(output);
	}

	// 맨해튼 거리 구하기
	private static int Manhattan(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}

	private static String BFS() {
		Queue<Integer> Q = new LinkedList<>();
		boolean [] visited = new boolean [N + 2];
		
		Q.add(0);
		visited[0] = true;
		
		while(!Q.isEmpty()) {
			int num = Q.poll();
			
			if(num == N + 1) return "happy\n";
			
			for(int i = 0; i < N + 2; i++) {
				if(connected[num][i] && !visited[i]) {
					Q.add(i);
					visited[i] = true;
				}
			}
		}
		
		return "sad\n";
	}

}

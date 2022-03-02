import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2583_영역구하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, K;
	static int [][] map;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		map = new int [N][M];
		for(int i = 0; i < K; i++) {
			tokens = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken()) - 1;
			int x2 = Integer.parseInt(tokens.nextToken()) - 1;
			
			for(int r = x1; r <= x2; r++) {
				for(int c = y1; c <= y2; c++) {
					map[r][c] = 1;
				}
			}
		}

		int cnt = 0; // 영역의 개수
		List<Integer> nums = new ArrayList<Integer>(); // 영역 넓이
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 1) continue;
				
				Queue<Point> Q = new LinkedList<Point>();
				Q.offer(new Point(r, c));
				map[r][c] = 1;
				cnt++;
				
				int num = 0; // 영역의 넓이
				while(!Q.isEmpty()) {
					Point now = Q.poll();
					num++;
					
					for(int i = 0; i < 4; i++) {
						int nr = now.r + dr[i];
						int nc = now.c + dc[i];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1) continue;
						
						Q.offer(new Point(nr, nc));
						map[nr][nc] = 1;
					}
				}
				
				nums.add(num);
			}
		}
		
		Collections.sort(nums);
		
		output.append(cnt + "\n");
		for(int i = 0; i < nums.size(); i++) {
			output.append(nums.get(i) + " ");
		}
		System.out.println(output);
	}

}

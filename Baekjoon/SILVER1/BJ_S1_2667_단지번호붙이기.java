import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_S1_2667_단지번호붙이기 {
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		Queue<Point> Q = new LinkedList<Point>();
		int [] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
		
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int[N][N];
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
		
		int cnt = 0; // 단지 수
		List<Integer> aparts = new ArrayList<>();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 집이 있다면
				if(map[r][c] == 1) {
					Q.offer(new Point(r, c));
					map[r][c] = 0;
					cnt++; // 아파트 단지 수 증가
					int apartCnt = 0;
					
					while(!Q.isEmpty()) {
						Point p = Q.poll();
						apartCnt++;
						
						for(int i = 0; i < 4; i++) {
							int nr = p.r + dx[i];
							int nc = p.c + dy[i];
							
							if(isIn(nr, nc, N) && map[nr][nc] == 1) {
								Q.offer(new Point(nr, nc));
								map[nr][nc] = 0;
							}
						}
					} // end while
					
					aparts.add(apartCnt);
				}
			}
		}
		Collections.sort(aparts);
		
		output.append(cnt).append('\n');
		for(int i = 0; i < cnt; i++) {
			output.append(aparts.get(i)).append('\n');
		}
		System.out.println(output);
	}

	private static boolean isIn(int r, int c, int N) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
